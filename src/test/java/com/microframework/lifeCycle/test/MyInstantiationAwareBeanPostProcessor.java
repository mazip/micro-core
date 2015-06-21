package com.microframework.lifeCycle.test;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter{



	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName)
			throws BeansException {
		if("car".equals(beanName)){
			System.out.println("postProcessAfterInstantiation 方法");
		}
		return true;
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass,
			String beanName) throws BeansException {
		if("car".equals(beanName)){
			System.out.println("postProcessBeforeInstantiation 方法");
		}
		
		return null;
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs,
			PropertyDescriptor[] pds, Object bean, String beanName)
			throws BeansException {
		
		if("car".equals(beanName)){
			System.out.println("postProcessPropertyValues 方法");
		}
		return pvs;
	}

	
	
	
}
