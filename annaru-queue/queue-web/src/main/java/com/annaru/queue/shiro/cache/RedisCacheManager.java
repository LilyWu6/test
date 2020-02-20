package com.annaru.queue.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author TuMinglong
 * @Descriptin 实现shiro的CacheManager
 * @Date 2018年5月1日 下午3:22:49
 */
@Component
public class RedisCacheManager implements CacheManager {

    @Value("${annaru.shiro.cache}")
    private String redis_shiro_cache;

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new ShiroCache<K, V>(redis_shiro_cache, name, redisTemplate);
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

}
