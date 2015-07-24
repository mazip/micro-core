package com.microframework.service;

import java.util.List;

import com.microframework.generator.dto.SysApp;

public interface AppService {

	public SysApp createApp(SysApp app);

	public SysApp updateApp(SysApp app);

	public void deleteApp(Long appId);

	public SysApp findOne(Long appId);

	public List<SysApp> findAll();

	/**
	 * 根据appKey查找AppId
	 * 
	 * @param appKey
	 * @return
	 */
	public Long findAppIdByAppKey(String appKey);
}
