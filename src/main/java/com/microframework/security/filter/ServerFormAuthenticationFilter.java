package com.microframework.security.filter;


import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ServerFormAuthenticationFilter extends FormAuthenticationFilter {

	private static Logger log = LoggerFactory.getLogger(ServerFormAuthenticationFilter.class);
	
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        
    	log.debug("ServerFormAuthenticationFilter coming");
    	String fallbackUrl = (String) getSubject(request, response)
                .getSession().getAttribute("authc.fallbackUrl");
        if(StringUtils.isEmpty(fallbackUrl)) {
            fallbackUrl = getSuccessUrl();
        }
        WebUtils.redirectToSavedRequest(request, response, fallbackUrl);
    }

}
