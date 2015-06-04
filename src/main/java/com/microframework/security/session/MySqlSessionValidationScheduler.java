package com.microframework.security.session;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import com.microframework.generator.client.SessionsMapper;
import com.microframework.generator.dto.Sessions;
import com.microframework.generator.dto.SessionsExample;
import com.microframework.generator.dto.SessionsExample.Criteria;
import com.microframework.util.SerializableUtils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;


public class MySqlSessionValidationScheduler implements SessionValidationScheduler, Runnable {



    /** Private internal log instance. */
    private static final Logger log = LoggerFactory.getLogger(MySqlSessionValidationScheduler.class);

    @Autowired
    private SessionsMapper sessionsMapper;
    
    ValidatingSessionManager sessionManager;
    private ScheduledExecutorService service;
    private long interval = DefaultSessionManager.DEFAULT_SESSION_VALIDATION_INTERVAL;
    private boolean enabled = false;

    public MySqlSessionValidationScheduler() {
        super();
    }

    public ValidatingSessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(ValidatingSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * Creates a single thread {@link java.util.concurrent.ScheduledExecutorService} to validate sessions at fixed intervals
     * and enables this scheduler. The executor is created as a daemon thread to allow JVM to shut down
     */
    //TODO Implement an integration test to test for jvm exit as part of the standalone example
    // (so we don't have to change the unit test execution model for the core module)
    public void enableSessionValidation() {
        if (this.interval > 0l) {
            this.service = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setDaemon(true);
                    return thread;
                }
            });
            this.service.scheduleAtFixedRate(this, interval, interval, TimeUnit.MILLISECONDS);
            this.enabled = true;
        }
    }

    public void run() {
        if (log.isDebugEnabled()) {
            log.debug("Executing session validation...");
        }
        long startTime = System.currentTimeMillis();

        
        //分页获取会话并验证
        //String sql = "select session from sessions limit ?,?";
        int start = 0; //起始记录
        int size = 20; //每页大小
        SessionsExample example=new SessionsExample();
        example.setLimitStart(start);
        example.setLimitEnd(size);
		List<Sessions> sessions = sessionsMapper.selectByExample(example);
		example.clear();
    
        //List<String> sessionList = jdbcTemplate.queryForList(sql, String.class, start, size);
        while(sessions.size() > 0) {
            for(Sessions sessionStr : sessions) {
                try {
                    Session session = SerializableUtils.deserialize(sessionStr.getSession());
                    Method validateMethod = ReflectionUtils.findMethod(AbstractValidatingSessionManager.class, "validate", Session.class, SessionKey.class);
                    validateMethod.setAccessible(true);
                    ReflectionUtils.invokeMethod(validateMethod, sessionManager, session, new DefaultSessionKey(session.getId()));
                } catch (Exception e) {
                    //ignore
                }
            }
            start = start + size;
            
            sessions = sessionsMapper.selectByExample(example);
            //sessionList = jdbcTemplate.queryForList(sql, String.class, start, size);
        }

        long stopTime = System.currentTimeMillis();
        if (log.isDebugEnabled()) {
            log.debug("Session validation completed successfully in " + (stopTime - startTime) + " milliseconds.");
        }
    }

    public void disableSessionValidation() {
        this.service.shutdownNow();
        this.enabled = false;
    }
}
