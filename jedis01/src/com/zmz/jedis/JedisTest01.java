package com.zmz.jedis;

import redis.clients.jedis.Jedis;

public class JedisTest01 {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.96.101",6379);
		
		System.out.println(jedis.ping());
		
		System.out.println(jedis.keys("*"));
		
		jedis.expire("k1", 10);
		
		System.out.println(jedis.ttl("k1"));
	}
}
