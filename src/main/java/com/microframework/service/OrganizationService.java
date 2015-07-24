package com.microframework.service;

import java.util.List;

import com.microframework.generator.dto.SysOrganization;

public interface OrganizationService {

	public SysOrganization createOrganization(SysOrganization organization);

	public SysOrganization updateOrganization(SysOrganization organization);

	public void deleteOrganization(Long organizationId);

	SysOrganization findOne(Long organizationId);

	List<SysOrganization> findAll();

	Object findAllWithExclude(SysOrganization excludeOraganization);

	void move(SysOrganization source, SysOrganization target);
}
