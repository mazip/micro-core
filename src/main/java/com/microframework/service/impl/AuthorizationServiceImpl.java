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
        return merge(authorization);
    }

    public SysUserAppRoles updateAuthorization(SysUserAppRoles authorization) {
        return merge(authorization);
    }

    public SysUserAppRoles merge(SysUserAppRoles authorization) {
    	
    	SysUserAppRolesExample example=new SysUserAppRolesExample();
    	example.createCriteria().andAppIdEqualTo(authorization.getAppId()).andUserIdEqualTo(authorization.getUserId());
		List<SysUserAppRoles> approles = sysUserAppRolesMapper.selectByExample(example);
		example.clear();
    	if(approles.size()==0){
    		sysUserAppRolesMapper.insert(authorization);
            return authorization;
    	}
		

        if(approles.get(0).equals(authorization)) {
        	//如果是同一条记录直接更新即可
        	sysUserAppRolesMapper.updateByExample(authorization, example);
        	example.createCriteria().andAppIdEqualTo(authorization.getAppId());
            return authorization;
        }

        
        
        
        for(Long roleId : authorization.getRoleIds()) {//否则合并
            if(!dbAuthorization.getRoleIds().contains(roleId)) {
                dbAuthorization.getRoleIds().add(roleId);
            }
        }

        if(dbAuthorization.getRoleIds().isEmpty()) {//如果没有角色 直接删除记录即可
            authorizationDao.deleteAuthorization(dbAuthorization.getId());
            return dbAuthorization;
        }
        //否则更新
        return authorizationDao.updateAuthorization(dbAuthorization);
    }

    public void deleteAuthorization(Long authorizationId) {
    	
    	sysUserAppRolesMapper.deleteByPrimaryKey(authorizationId);
    }

    @Override
    public Authorization findOne(Long authorizationId) {
        return authorizationDao.findOne(authorizationId);
    }

    @Override
    public List<Authorization> findAll() {
        return authorizationDao.findAll();
    }

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String appKey, String username) {
        SysUser user = userService.findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        Long appId = appService.findAppIdByAppKey(appKey);
        if(appId == null) {
            return Collections.EMPTY_SET;
        }
        Authorization authorization = authorizationDao.findByAppUser(appId, user.getId());
        if(authorization == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(authorization.getRoleIds().toArray(new Long[0]));
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String appKey, String username) {
        SysUser user = userService.findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        Long appId = appService.findAppIdByAppKey(appKey);
        if(appId == null) {
            return Collections.EMPTY_SET;
        }
        Authorization authorization = authorizationDao.findByAppUser(appId, user.getId());
        if(authorization == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findPermissions(authorization.getRoleIds().toArray(new Long[0]));
    }


}
