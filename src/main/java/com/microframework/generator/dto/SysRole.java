package com.microframework.generator.dto;

public class SysRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.role
     *
     * @mbggenerated
     */
    private String role;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.description
     *
     * @mbggenerated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.resource_ids
     *
     * @mbggenerated
     */
    private String resourceIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.available
     *
     * @mbggenerated
     */
    private Boolean available;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.id
     *
     * @return the value of sys_role.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.id
     *
     * @param id the value for sys_role.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.role
     *
     * @return the value of sys_role.role
     *
     * @mbggenerated
     */
    public String getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.role
     *
     * @param role the value for sys_role.role
     *
     * @mbggenerated
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.description
     *
     * @return the value of sys_role.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.description
     *
     * @param description the value for sys_role.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.resource_ids
     *
     * @return the value of sys_role.resource_ids
     *
     * @mbggenerated
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.resource_ids
     *
     * @param resourceIds the value for sys_role.resource_ids
     *
     * @mbggenerated
     */
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.available
     *
     * @return the value of sys_role.available
     *
     * @mbggenerated
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.available
     *
     * @param available the value for sys_role.available
     *
     * @mbggenerated
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }
}