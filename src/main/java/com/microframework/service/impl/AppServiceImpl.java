package com.microframework.service.impl;

import com.microframework.generator.client.SysAppMapper;
import com.microframework.generator.dto.SysApp;
import com.microframework.generator.dto.SysAppExample;
import com.microframework.service.AppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private SysAppMapper sysAppMapper;

	public SysApp createApp(SysApp app) {
		int i = sysAppMapper.insert(app);
		if (i >= 0) {
			return app;
		} else {
			return null;
		}

	}

	public SysApp updateApp(SysApp app) {
		
		SysAppExample example=new SysAppExample();
		example.createCriteria().andIdEqualTo(app.getId());
		int i = sysAppMapper.updateByExampleSelective(app, example);
		example.clear();
		if(i>=0){
			return app;
		}else{
			return null;
		}
		
	}

	public void deleteApp(Long appId) {
		
		sysAppMapper.deleteByPrimaryKey(appId);
		
	}

	public SysApp findOne(Long appId) {
		
		
		return sysAppMapper.selectByPrimaryKey(appId);
	}

	public List<SysApp> findAll() {
		
		SysAppExample example=new SysAppExample();
		
		return sysAppMapper.selectByExample(example);
	}

	
	public Long findAppIdByAppKey(String appKey) {
		
        SysAppExample example=new SysAppExample();
		example.createCriteria().andAppKeyEqualTo(appKey);
		List<SysApp> sapps = sysAppMapper.selectByExample(example);
		if(sapps.size()>0){
			return sapps.get(0).getId();
		}else{
			return 0l;
		}
		
	}
}
