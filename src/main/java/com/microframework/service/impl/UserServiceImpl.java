package com.microframework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.microframework.generator.client.SysUserMapper;
import com.microframework.generator.dto.SysUser;
import com.microframework.generator.dto.SysUserExample;
import com.microframework.generator.dto.SysUserExample.Criteria;
import com.microframework.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private SysUserMapper sysUserMapper;
	
	public SysUser findByUsername(String username) {
		
		SysUserExample example = new SysUserExample();
		Criteria ci = example.createCriteria();
		ci.andUsernameEqualTo(username);
		List<SysUser> su = sysUserMapper.selectByExample(example);
		example.clear();
		if(su.size()>0){
			return su.get(0);
		}else{
			return null;
		}
	}

}
