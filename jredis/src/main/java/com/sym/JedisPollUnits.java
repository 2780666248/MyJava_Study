package com.sym;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

import java.util.ArrayList;
import java.util.List;

public class JedisPollUnits {
    private static JedisPool pool;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        pool = new JedisPool(config,"127.0.0.1",6379);
    }
    public static Jedis open(){
        Jedis jedis = pool.getResource();
        jedis.auth("tyzx99ty!");
        return jedis;
    }
}
