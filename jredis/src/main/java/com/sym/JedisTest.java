package com.sym;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = JedisPollUnits.open();
        jedis.zadd("llll",1,"hhhhh");

        jedis.close();
    }
}
