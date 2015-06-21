package com.microframework.lifeCycle.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{

	private String brand;
	private String color;
	private int maxSpeed;
	
	
	
	private BeanFactory beanFactory;
	private String beanName;
	
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public Car(){
		
		System.out.println("Car 的无参构造器");
		
	}
	
	public void setBrand(String brand){
		System.out.println("设置Car brand 属性");
		this.brand=brand;
	}
	
	public void introduce(){
		System.out.println("brand:"+brand+";color:"+";maxSpeed:"+maxSpeed);
		
	}
	
	//DisposableBean接口方法
	public void destroy() throws Exception {
		System.out.println("调用 destroy方法");
		
	}

	// InitializingBean 接口方法
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用 afterPropertiesSet方法");
		
	}

	// BeanNameAware 接口方法
	public void setBeanName(String arg0) {
		System.out.println("调用 setBeanName方法");
		
	}

	// BeanFactoryAware 接口方法
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("调用 setBeanFactory方法");
		this.beanFactory=beanFactory;
	}
	
	// init-method属性指定初始化方法
	public void myInit(){
		System.out.println("调用 myInit 初始化方法");
		this.maxSpeed=240;
	}
	//destroy-method属性指定的销毁方法
	public void myDestroy(){
		System.out.println("调用 destroy-method指定的myDestroy");
		
	}

}
