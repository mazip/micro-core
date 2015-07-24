package com.microframework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microframework.generator.client.SysRoleMapper;
import com.microframework.generator.dto.SysRole;
import com.microframework.generator.dto.SysRoleExample;
import com.microframework.service.ResourceService;
import com.microframework.service.RoleService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private ResourceService resourceService;

	public SysRole createRole(SysRole role) {

		int i = sysRoleMapper.insert(role);

		if (i > 0) {
			return role;
		} else {
			return null;
		}

	}

	public SysRole updateRole(SysRole role) {

		SysRoleExample example = new SysRoleExample();
		example.createCriteria().andIdEqualTo(role.getId());
		sysRoleMapper.updateByExampleSelective(role, example);
		example.clear();
		return role;
	}

	public void deleteRole(Long roleId) {

		sysRoleMapper.deleteByPrimaryKey(roleId);
	}

	public SysRole findOne(Long roleId) {

		return sysRoleMapper.selectByPrimaryKey(roleId);

	}

	public List<SysRole> findAll() {

		SysRoleExample example = new SysRoleExample();
		return sysRoleMapper.selectByExample(example);

	}

	public Set<String> findRoles(Long... roleIds) {
		Set<String> roles = new HashSet<String>();
		for (Long roleId : roleIds) {
			SysRole role = findOne(roleId);
			if (role != null) {
				roles.add(role.getRole());
			}
		}
		return roles;
	}

	public Set<String> findPermissions(Long[] roleIds) {
		Set<Long> resourceIds = new HashSet<Long>();
		for (Long roleId : roleIds) {
			SysRole role = findOne(roleId);

			String rids = role.getResourceIds();

			List<Long> ridlist = new ArrayList<Long>();

			String[] r = rids.split(",");

			for (int i = 0; i < r.length; i++) {
				ridlist.add(Long.parseLong(r[i]));
			}

			if (role != null) {
				resourceIds.addAll(ridlist);
			}
		}
		return resourceService.findPermissions(resourceIds);
	}
}
