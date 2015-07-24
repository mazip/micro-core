package com.microframework.service;


import java.util.List;
import java.util.Set;
import com.microframework.generator.dto.SysUserAppRoles;


/**

 */
public interface AuthorizationService {


    public SysUserAppRoles createAuthorization(SysUserAppRoles authorization);
    public SysUserAppRoles updateAuthorization(SysUserAppRoles authorization);
    public void deleteAuthorization(Long authorizationId);

    public SysUserAppRoles findOne(Long authorizationId);
    public List<SysUserAppRoles> findAll();

    /**
     * 根据AppKey和用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String appKey, String username);

    /**
     * 根据AppKey和用户名查找权限字符串
     * @param username
     * @return
     */
    public Set<String> findPermissions(String appKey, String username);


}
