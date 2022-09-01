package com.macro.ocp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import javax.annotation.Resource;
import java.time.Duration;


/**
 *
 * 缓存自动序列化格式与缓存生存周期
 * @author zhangkein
 */
@Configuration
public class MyCacheManger {

    @Resource
    private RedisTemplate redisTemplate;

    RedisCacheConfiguration getCacheConfigurationWithTtl(long seconds)
    {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getStringSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()))
                .disableCachingNullValues()
                .entryTtl(Duration.ofSeconds(seconds));
    }

    @Bean
    public RedisCacheManager redisCacheManager(){
        RedisCacheConfiguration defaultCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getStringSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()))
                .disableCachingNullValues();

        RedisCacheManager redisCacheManager = RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(redisTemplate.getConnectionFactory())
                .withCacheConfiguration("empinfo", getCacheConfigurationWithTtl(5 * 60))//2分钟
                .cacheDefaults(getCacheConfigurationWithTtl( 60 * 60))//60分钟
                .transactionAware()
                .build();
        return redisCacheManager;

    }
}
