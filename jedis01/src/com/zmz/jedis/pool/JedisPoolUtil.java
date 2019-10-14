package com.zmz.jedis.pool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
	//似有构造器
	private JedisPoolUtil() {
		
	}
	private static JedisPool jedisPool;
	//共有的静态方法返回链接
	public static Jedis getResource() {
		if(jedisPool == null) {
			//创建连接
			JedisPoolConfig config = new JedisPoolConfig();
			//最大连接数
			config.setMaxTotal(1000);
			//最大空闲数
			config.setMaxIdle(10);
			//最大等待数
			config.setMaxWaitMillis(1000);
			//测试获取链接时候可用
			jedisPool = new JedisPool(config,"192.168.96.101",6379);
			
		}
		return jedisPool.getResource();
	}
}
