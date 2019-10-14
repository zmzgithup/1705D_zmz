package com.zmz.jedis.pool;

import redis.clients.jedis.Jedis;

public class JedisPoolTest {
	public static void main(String[] args) {
		Jedis jedis = JedisPoolUtil.getResource();
		System.out.println(jedis.ping());
	}
}
 