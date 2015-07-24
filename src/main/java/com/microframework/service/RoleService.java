package com.microframework.service;

import java.util.List;
import java.util.Set;

import com.microframework.generator.dto.SysRole;

public interface RoleService {

	public SysRole createRole(SysRole role);

	public SysRole updateRole(SysRole role);

	public void deleteRole(Long roleId);

	public SysRole findOne(Long roleId);

	public List<SysRole> findAll();

	/**
	 * 根据角色编号得到角色标识符列表
	 * 
	 * @param roleIds
	 * @return
	 */
	Set<String> findRoles(Long... roleIds);

	/**
	 * 根据角色编号得到权限字符串列表
	 * 
	 * @param roleIds
	 * @return
	 */
	Set<String> findPermissions(Long[] roleIds);
}
