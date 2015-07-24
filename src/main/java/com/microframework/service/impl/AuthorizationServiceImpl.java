package com.microframework.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microframework.generator.client.SysUserAppRolesMapper;
import com.microframework.generator.dto.SysUser;
import com.microframework.generator.dto.SysUserAppRoles;
import com.microframework.generator.dto.SysUserAppRolesExample;
import com.microframework.service.AppService;
import com.microframework.service.AuthorizationService;
import com.microframework.service.RoleService;
import com.microframework.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private SysUserAppRolesMapper sysUserAppRolesMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AppService appService;
	public SysUserAppRoles createAuthorization(SysUserAppRoles authorization) {
		// TODO Auto-generated method stub
		return null;
	}
	public SysUserAppRoles updateAuthorization(SysUserAppRoles authorization) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deleteAuthorization(Long authorizationId) {
		// TODO Auto-generated method stub
		
	}
	public SysUserAppRoles findOne(Long authorizationId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<SysUserAppRoles> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public Set<String> findRoles(String appKey, String username) {
		// TODO Auto-generated method stub
		return null;
	}
	public Set<String> findPermissions(String appKey, String username) {
		// TODO Auto-generated method stub
		return null;
	}

    


}
