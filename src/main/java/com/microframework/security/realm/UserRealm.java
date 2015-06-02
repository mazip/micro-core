/**
 * Project Name:micro-core
 * File Name:UserRealm.java
 * Package Name:com.microframework.security.realm
 * Date:2015-6-2ÏÂÎç2:17:35
 * Copyright (c) 2015, 314059610@qq.com All Rights Reserved.
 *
*/

package com.microframework.security.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName:UserRealm <br/>
 * @author   Mazip
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class UserRealm extends AuthorizingRealm{

//	
//	@Autowired
//    private UserService userService;
//
//    @Autowired
//    private AuthorizationService authorizationService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		
	
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		
		
		return null;
	}

}

