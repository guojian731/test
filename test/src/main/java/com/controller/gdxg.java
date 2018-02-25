package com.controller;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class gdxg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		    Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();  
	        //Jedis Cluster will attempt to discover cluster nodes automatically  
	        jedisClusterNodes.add(new HostAndPort("192.168.3.8", 7000));  
	        JedisCluster jc = new JedisCluster(jedisClusterNodes);  
	        jc.set("foo", "bar");  
	        String value = jc.get("foo");  
	        System.out.println(value);  
	}

}
