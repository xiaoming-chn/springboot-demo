package top.xiaoming.demo.springbootdemo.config.beans.redis;

import java.time.Duration;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableCaching
public class RedisConfig {
	
	/**
	 * Redis操作模板
	 * @param redisConnectionFactory
	 * @return
	 */
	@Bean
	public RedisTemplate<String, ?> redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, ?> template = new RedisTemplate<>();
		StringRedisSerializer keySerializer = new StringRedisSerializer();
		GenericJackson2JsonRedisSerializer valueSerializer = new GenericJackson2JsonRedisSerializer();
        
		template.setKeySerializer(keySerializer);
		template.setValueSerializer(valueSerializer);
		template.setHashKeySerializer(keySerializer);
		template.setHashValueSerializer(valueSerializer);
		
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}
	
	/**
	 * Redis缓存管理器
	 * @param redisConnectionFactory
	 * @return
	 */
    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory redisConnectionFactory) {
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
                .RedisCacheManagerBuilder
                .fromConnectionFactory(redisConnectionFactory);
        
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
        		.entryTtl(Duration.ofHours(1L))
        		.disableCachingNullValues();
        builder.cacheDefaults(defaultCacheConfig);
        
        return builder.build();
    }
}
