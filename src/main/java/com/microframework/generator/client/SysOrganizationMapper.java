package com.microframework.generator.client;

import com.microframework.generator.dto.SysOrganization;
import com.microframework.generator.dto.SysOrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysOrganizationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    int countByExample(SysOrganizationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    int deleteByExample(SysOrganizationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    int insert(SysOrganization record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    int insertSelective(SysOrganization record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    List<SysOrganization> selectByExample(SysOrganizationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    SysOrganization selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysOrganization record, @Param("example") SysOrganizationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysOrganization record, @Param("example") SysOrganizationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysOrganization record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_organization
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysOrganization record);
}