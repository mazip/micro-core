/**
 * Project Name:micro-core
 * File Name:UserRealm.java
 * Package Name:com.microframework.security.realm
 * Date:2015-6-2����2:17:35
 * Copyright (c) 2015, 314059610@qq.com All Rights Reserved.
 *
*/

package com.microframework.security.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.microframework.service.AuthorizationService;
import com.microframework.service.UserService;

/**
 * ClassName:UserRealm <br/>
 * @author   Mazip
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class UserRealm extends AuthorizingRealm{
	 @Autowired
	    private UserService userService;

	    @Autowired
	    private AuthorizationService authorizationService;

	    @Override
	    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	        String username = (String)principals.getPrimaryPrincipal();

	        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
	        authorizationInfo.setRoles(authorizationService.findRoles(Constants.SERVER_APP_KEY, username));
	        authorizationInfo.setStringPermissions(authorizationService.findPermissions(Constants.SERVER_APP_KEY, username));
	        return authorizationInfo;
	    }

	    @Override
	    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

	        String username = (String)token.getPrincipal();

	        User user = userService.findByUsername(username);

	        if(user == null) {
	            throw new UnknownAccountException();//没找到帐号
	        }

	        if(Boolean.TRUE.equals(user.getLocked())) {
	            throw new LockedAccountException(); //帐号锁定
	        }

	        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
	        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	                user.getUsername(), //用户名
	                user.getPassword(), //密码
	                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
	                getName()  //realm name
	        );
	        return authenticationInfo;
	    }

	    @Override
	    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
	        super.clearCachedAuthorizationInfo(principals);
	    }

	    @Override
	    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
	        super.clearCachedAuthenticationInfo(principals);
	    }

	    @Override
	    public void clearCache(PrincipalCollection principals) {
	        super.clearCache(principals);
	    }

	    public void clearAllCachedAuthorizationInfo() {
	        getAuthorizationCache().clear();
	    }

	    public void clearAllCachedAuthenticationInfo() {
	        getAuthenticationCache().clear();
	    }

	    public void clearAllCache() {
	        clearAllCachedAuthenticationInfo();
	        clearAllCachedAuthorizationInfo();
	    }

}

