package com.microframework.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.microframework.generator.dto.SysResource;
import com.microframework.service.ResourceService;
import java.util.List;
import java.util.Set;


@Service
public class ResourceServiceImpl implements ResourceService {

	public SysResource createResource(SysResource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	public SysResource updateResource(SysResource resource) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteResource(Long resourceId) {
		// TODO Auto-generated method stub
		
	}

	public SysResource findOne(Long resourceId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SysResource> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> findPermissions(Set<Long> resourceIds) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SysResource> findMenus(Set<String> permissions) {
		// TODO Auto-generated method stub
		return null;
	}

   
}
