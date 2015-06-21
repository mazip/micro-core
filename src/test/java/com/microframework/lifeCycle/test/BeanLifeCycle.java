package com.microframework.lifeCycle.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {

	private static void LifeCycleInBeanFactory(){
		
		Resource res = new ClassPathResource("com/microframework/lifeCycle/test/servlet-context.xml");
		
		BeanFactory bf = new XmlBeanFactory(res);
		
		//注册后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
		//注册后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

		Car car = (Car)bf.getBean("car");
		car.introduce();
		car.setColor("黄色");
		
		Car car1 = (Car)bf.getBean("car");
		
		System.out.println("car==car1:"+(car==car1));
		
		((XmlBeanFactory)bf).destroySingletons();
		
	}
	
	//如果scope是prototype 那么 每次都是新的实例
	public static void main(String[] args) {
		LifeCycleInBeanFactory();
	}
}
