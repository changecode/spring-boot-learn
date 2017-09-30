package com.springboot.redis.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

/**
 * Created by WIN on 2017/9/29.
 */
@Component
public class RedisTemplateOperator {

    private static final Logger logger = LoggerFactory.getLogger(RedisTemplateOperator.class);
    private static final String KEY_SPLIT = ":";
    @Autowired
    private JedisCluster jedisCluster;

    @Autowired
    private RedisProperties redisProperties;

    /**
     *  set cache value
     * @param prefix
     * @param key
     * @param value
     */
    public void set(String prefix, String key, String value) {
        jedisCluster.set(prefix + KEY_SPLIT + key, value);
        logger.debug("set cache key={}. value={}",prefix+key, value);
    }

    /**
     * set cache value with expire
     * @param prefix
     * @param key
     * @param value
     */
    public void setWithExpireTime(String prefix, String key, String value, int timeout) {
        jedisCluster.setex(prefix + KEY_SPLIT + key, timeout, value);
        logger.debug("setWithExpireTime cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value, timeout);
    }

    /**
     * set cache value with expire value from properties file
     * @param prefix
     * @param key
     * @param value
     */
    public void setWithExpireTimeFromProperties(String prefix, String key, String value) {
        int expireTime = redisProperties.getCommandTimeout();
        jedisCluster.setex(prefix + KEY_SPLIT + key, expireTime, value);
        logger.debug("setWithExpireTimeFromProperties cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value, expireTime);
    }

    /**
     * get value from cache
     * @param prefix
     * @param key
     * @return
     */
    public String get(String prefix, String key) {
        String value = jedisCluster.get(prefix + KEY_SPLIT + key);
        logger.debug("get cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value);
        return value;
    }

    /**
     * delete cache value with prefix
     * @param prefix
     * @param key
     */
    public void deleteWithPrefix(String prefix, String key) {
        jedisCluster.del(prefix + KEY_SPLIT + key);
        logger.debug("deleteWithPrefix key={}",key);
    }

    /**
     * delete cache value
     * @param key
     */
    public void delete(String key) {
        jedisCluster.del(key);
        logger.debug("delete key={}",key);
    }
}
