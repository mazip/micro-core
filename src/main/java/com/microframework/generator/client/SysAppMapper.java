package com.microframework.generator.client;

import com.microframework.generator.dto.SysApp;
import com.microframework.generator.dto.SysAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAppMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    int countByExample(SysAppExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    int deleteByExample(SysAppExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    int insert(SysApp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    int insertSelective(SysApp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    List<SysApp> selectByExample(SysAppExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    SysApp selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SysApp record, @Param("example") SysAppExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SysApp record, @Param("example") SysAppExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysApp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_app
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysApp record);
}