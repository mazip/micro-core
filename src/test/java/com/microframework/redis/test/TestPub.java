package com.microframework.redis.test;

import redis.clients.jedis.Jedis;

public class TestPub {

	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("192.168.1.100",6379);
		jedis.auth("mazip1234");
		
		jedis.publish("hello_mazip", "lalalala");
		jedis.publish("hello_test", "hello watson");
		
	}
}
