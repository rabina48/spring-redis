//package com.project.cacheimpl.cache;
//
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.redis.serializer.GenericToStringSerializer;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Rabina Shrestha
// * @EmaiL rabina.shrestha@f1soft.com
// */
//@Configuration
//@EnableRedisRepositories
//public class RedisCon {
//
//
//
//        @Bean
//        public JedisConnectionFactory jedisConnectionFactory() {
//            RedisProperties properties = redisProperties();
//            RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//            configuration.setHostName(properties.getHost());
//            configuration.setPort(properties.getPort());
//
//            return new JedisConnectionFactory(configuration);
//        }
//
//        @Bean
//        public RedisTemplate<String, Object> redisTemplate() {
//            final RedisTemplate<String, Object> template = new RedisTemplate<>();
//            template.setConnectionFactory(jedisConnectionFactory());
//            template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
//            return template;
//        }
//
//        @Bean
//        @Primary
//        public RedisProperties redisProperties() {
//            return new RedisProperties();
//        }
//
//    @Bean(name = "redisManager")
//    public CacheManager cacheManager() {
//
//        return new CacheManager() {
//            @Override
//            public Cache getCache(String s) {
//                return null;
//            }
//
//            @Override
//            public Collection<String> getCacheNames() {
//                return null;
//            }
//        };
//    }
//}
