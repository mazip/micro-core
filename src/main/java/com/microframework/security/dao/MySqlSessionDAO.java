package com.microframework.security.dao;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.microframework.generator.client.SessionsMapper;
import com.microframework.generator.dto.Sessions;
import com.microframework.generator.dto.SessionsExample;
import com.microframework.util.SerializableUtils;

import java.io.Serializable;
import java.util.List;


public class MySqlSessionDAO extends CachingSessionDAO {

    @Autowired
	private SessionsMapper sessionsMapper;
	

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        
        Sessions record=new Sessions();
        record.setId(sessionId.toString());
        record.setSession(SerializableUtils.serialize(session));
		sessionsMapper.insertSelective(record);
        return session.getId();
    }
    @Override
    protected void doUpdate(Session session) {
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return; 
        }
        
        SessionsExample example=new SessionsExample();
        example.createCriteria().andIdEqualTo(session.getId().toString());
		Sessions record=new Sessions();
		record.setSession(SerializableUtils.serialize(session));
		sessionsMapper.updateByExampleSelective(record, example);
		example.clear();
    }
    @Override
    protected void doDelete(Session session) {
    	
    	SessionsExample example=new SessionsExample();
    	example.createCriteria().andIdEqualTo(session.getId().toString());
		sessionsMapper.deleteByExample(example);
		example.clear();
    }
    @Override
    protected Session doReadSession(Serializable sessionId) {
    	SessionsExample example=new SessionsExample();
    	example.createCriteria().andIdEqualTo(sessionId.toString());
		List<Sessions> sessions = sessionsMapper.selectByExample(example);
		example.clear();
		if(sessions.size()==0){
			return null;
		}
        return SerializableUtils.deserialize(sessions.get(0).getSession());
    }
}
