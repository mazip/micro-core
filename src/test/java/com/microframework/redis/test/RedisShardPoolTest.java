package com.microframework.redis.test;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

public class RedisShardPoolTest {

	static ShardedJedisPool pool;
	static {
		JedisPoolConfig config = new JedisPoolConfig();// Jedis池配置
		config.setMaxTotal(500);
		config.setMaxIdle(1000 * 60);// 对象最大空闲时间
		config.setMaxWaitMillis(1000 * 10);// 获取对象时最大等待时间
		config.setTestOnBorrow(true);

		String hostA = "192.168.1.100";
		int portA = 6379;
		String hostB = "192.168.1.101";
		int portB = 6379;
		String hostC = "192.168.1.102";
		int portC = 6379;

		List<JedisShardInfo> jdsInfoList = new ArrayList<JedisShardInfo>(2);
		JedisShardInfo infoA = new JedisShardInfo(hostA,"shared-1", portA,2000,1);
		System.out.println(infoA.getName());
		JedisShardInfo infoB = new JedisShardInfo(hostB,"shared-2", portB,2000,1);
		System.out.println(infoB.getName());
//		JedisShardInfo infoC = new JedisShardInfo(hostC,"shared-3", portC,2000,1);
//		System.out.println(infoC.getName());

		
		jdsInfoList.add(infoA);
		jdsInfoList.add(infoB);
		//jdsInfoList.add(infoC);

		pool = new ShardedJedisPool(config, jdsInfoList, Hashing.MURMUR_HASH,
				Sharded.DEFAULT_KEY_TAG_PATTERN);
	}

	static int m = 0;
	static int n = 0;
	static int j = 0;

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			String key = generateKey();
			ShardedJedis jds = null;
			try {
				jds = pool.getResource();

				if ("192.168.1.100".equals(jds.getShard(key).getClient()
						.getHost())) {
					m++;
				}
				if ("192.168.1.101".equals(jds.getShard(key).getClient()
						.getHost())) {
					n++;
				}
				if ("192.168.1.102".equals(jds.getShard(key).getClient()
						.getHost())) {
					j++;
				}

				System.out.println(jds.set(key,
						"1111111111111111111111111111111"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.returnResource(jds);
			}
		}
		System.out.println("m n j:"+m+"-"+n+"-"+j);
	}

	private static int index = 1;

	public static String generateKey() {
		return String.valueOf(Thread.currentThread().getId()) + "_" + (index++);
	}
}
