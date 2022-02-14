package com.jokertian.rediscahce.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author joker-tian
 */
@Configuration
public class RedisConfig {
    @Bean
    public CacheManager newCacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                // 设置缓存默认过期时间
                .entryTtl(Duration.ofMinutes(30))
                // 覆盖默认的构造key，否则会多出一个冒号
                .computePrefixWith(cacheName -> cacheName + ":")
                // 不缓存空值
                .disableCachingNullValues()
                // key使用字符串序列化
                .serializeValuesWith(keySerializationPair())
                // value使用JSON序列化
                .serializeValuesWith(valueSerializationPair());
        return RedisCacheManager.builder(factory)
                .withCacheConfiguration("user", configuration)
                .build();
    }

    private RedisSerializationContext.SerializationPair<String> keySerializationPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
    }

    private RedisSerializationContext.SerializationPair<Object> valueSerializationPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    }
}
