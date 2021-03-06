package com.microframework.generator.dto;

public class SysUserAppRoles {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_app_roles.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_app_roles.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_app_roles.app_id
     *
     * @mbggenerated
     */
    private Long appId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_app_roles.role_ids
     *
     * @mbggenerated
     */
    private String roleIds;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_app_roles.id
     *
     * @return the value of sys_user_app_roles.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_app_roles.id
     *
     * @param id the value for sys_user_app_roles.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_app_roles.user_id
     *
     * @return the value of sys_user_app_roles.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_app_roles.user_id
     *
     * @param userId the value for sys_user_app_roles.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_app_roles.app_id
     *
     * @return the value of sys_user_app_roles.app_id
     *
     * @mbggenerated
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_app_roles.app_id
     *
     * @param appId the value for sys_user_app_roles.app_id
     *
     * @mbggenerated
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_app_roles.role_ids
     *
     * @return the value of sys_user_app_roles.role_ids
     *
     * @mbggenerated
     */
    public String getRoleIds() {
        return roleIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_app_roles.role_ids
     *
     * @param roleIds the value for sys_user_app_roles.role_ids
     *
     * @mbggenerated
     */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }
}