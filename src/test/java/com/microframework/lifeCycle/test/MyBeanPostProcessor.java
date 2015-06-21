package com.microframework.lifeCycle.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if(beanName.equals("car")){
			Car car = (Car)bean;
			if(car.getMaxSpeed()>=200){
				System.out.println("调整速度到200 ");
				car.setMaxSpeed(200);
			}
			
		}
		
		return bean;
		
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(beanName.equals("car")){
			Car car = (Car)bean;
			if(car.getColor()==null){
				System.out.println("调用 设置颜色 ");
				car.setColor("白色");
			}
			
		}
		
		return bean;
	}

}
