package com.microframework.redis.test;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

public class TestRedis {

	@Test
	public void testSet() {

		// 主
		Jedis jedis = new Jedis("192.168.1.100", 6379);
		jedis.auth("mazip1234");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");

		// 从
		Jedis jedis1 = new Jedis("192.168.1.101", 6379);
		Jedis jedis2 = new Jedis("192.168.1.102", 6379);
		String value1 = jedis.get("foo");
		String value2 = jedis.get("foo");

		System.out.println(value);
		System.out.println(value1);
		System.out.println(value2);

	}

	// EXPIRE key
	@Test
	public void testExprie() throws InterruptedException {

		Jedis jedis = new Jedis("192.168.1.100", 6379);
		jedis.auth("mazip1234");
		jedis.set("foo", "bar");
		jedis.expire("foo", 3);
		String value1 = jedis.get("foo");
		System.out.println("之前:" + value1);
		Thread.sleep(3000);
		String value2 = jedis.get("foo");
		System.out.println("之后:" + value2);

	}

	@Test
	public void testPipe() {
		Jedis jedis = new Jedis("192.168.1.100", 6379);
		jedis.auth("mazip1234");
		Pipeline p = jedis.pipelined();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			p.set("p" + i, "p" + i);
		}
		List<Object> results = p.syncAndReturnAll();
		long end = System.currentTimeMillis();
		System.out.println("Pipelined SET: " + results.size() + "--"
				+ ((end - start) / 1000.0) + " seconds");
	}

	@Test
	public void testTrans() {
		Jedis jedis = new Jedis("192.168.1.100", 6379);
		jedis.auth("mazip1234");
		long start = System.currentTimeMillis();
		Transaction tx = jedis.multi();
		for (int i = 0; i < 100000; i++) {
			tx.set("t" + i, "t" + i);
		}
		List<Object> results = tx.exec();
		long end = System.currentTimeMillis();
		System.out.println("Transaction SET: " + ((end - start) / 1000.0)
				+ " seconds");
	}

	
	@Test
	public void testShared(){
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.1.100", 6379);
		jedis.auth("mazip1234");

		MyListener listener = new MyListener();
		jedis.psubscribe(listener, new String[] { "hello_*" });
	}
}
