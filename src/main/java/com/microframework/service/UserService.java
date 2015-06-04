package com.microframework.service;

import org.springframework.stereotype.Service;
import com.microframework.generator.dto.SysUser;

@Service
public interface UserService {

	public SysUser findByUsername(String username);
	
	
}
