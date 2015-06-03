package com.microframework.generator.dto;

public class SysOrganization {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_organization.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_organization.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_organization.parent_id
     *
     * @mbggenerated
     */
    private Long parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_organization.parent_ids
     *
     * @mbggenerated
     */
    private String parentIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_organization.available
     *
     * @mbggenerated
     */
    private Boolean available;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_organization.id
     *
     * @return the value of sys_organization.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_organization.id
     *
     * @param id the value for sys_organization.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_organization.name
     *
     * @return the value of sys_organization.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_organization.name
     *
     * @param name the value for sys_organization.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_organization.parent_id
     *
     * @return the value of sys_organization.parent_id
     *
     * @mbggenerated
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_organization.parent_id
     *
     * @param parentId the value for sys_organization.parent_id
     *
     * @mbggenerated
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_organization.parent_ids
     *
     * @return the value of sys_organization.parent_ids
     *
     * @mbggenerated
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_organization.parent_ids
     *
     * @param parentIds the value for sys_organization.parent_ids
     *
     * @mbggenerated
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_organization.available
     *
     * @return the value of sys_organization.available
     *
     * @mbggenerated
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_organization.available
     *
     * @param available the value for sys_organization.available
     *
     * @mbggenerated
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }
}