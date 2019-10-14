package com.zmz.jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class JedisTest02 {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		//创建jedis
		Jedis jedis = new Jedis("192.168.96.101",6379);
		//string
		System.out.println("------string------");
		jedis.set("k1", "v1");
		System.out.println(jedis.get("k1"));
		//mset一次设置多个值
		jedis.mset("k2","20","k3","30");
		// +1 incr
		jedis.incr("k2");
		//遍历
		List<String> mget = jedis.mget("k1","k2","k3");
		for (String string : mget) {
			System.out.println(string);
		}
		//清空
		jedis.flushDB();
		System.out.println("------list------");
		//list 列表
		jedis.rpush("list1", "a","b","c","d");
		//删除
		jedis.lrem("list1", 1,"a");
		//遍历
		List<String> lrange = jedis.lrange("list1", 0, -1);
		for (String string : lrange) {
			System.out.println(string);
		}
		
		System.out.println("------set------");
		//set 集合
		jedis.sadd("set1", "1","2","3","4","1");
		//删除
		jedis.srem("set1", "4");
		//判断4是否存在
		System.out.println(jedis.sismember("set1", "4"));
		Set<String> smembers = jedis.smembers("set1");
		for (String string : smembers) {
			System.out.println(string);
		}
		
		System.out.println("------hash------");
		//hash 散列
		jedis.hset("s001", "name", "张三");
		System.out.println(jedis.hget("s001", "name"));
		Map map = new HashMap();
		map.put("name", "李四");
		map.put("age", "20");
		map.put("sex", "man");
		jedis.hmset("s002", map);
		List<String> hmget = jedis.hmget("s002", "name");
		for (String string : hmget) {
			System.out.println(string);
		}
		
		//zset 有序集合
		System.out.println("------zset-------");
		jedis.zadd("zset1", 10d, "v1");
		jedis.zadd("zset1", 20d, "v2");
		jedis.zadd("zset1", 30d, "v3");
		jedis.zadd("zset1", 5d, "v4");
		//分数递增
		jedis.zincrby("zset1", 30, "v4");
		//移除
		jedis.zrem("zset1", "v4");
		//遍历
		Set<String> zrange = jedis.zrange("zset1", 0, -1);
		for (String string : zrange) {
			System.out.println(string);
		}
	}
}
