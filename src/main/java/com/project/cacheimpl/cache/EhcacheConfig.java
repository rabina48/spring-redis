package com.project.cacheimpl.cache;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Rabina Shrestha
 * @EmaiL rabina.shrestha@f1soft.com
 */

@Configuration
public class EhcacheConfig {

    @Bean("ehcacheManager")
    EhCacheCacheManager cacheManager(){
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager(ehCacheManager());
        return   ehCacheCacheManager;
    }

    private net.sf.ehcache.CacheManager ehCacheManager(){
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
        factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factoryBean.setShared(true);
        return  factoryBean.getObject();
    }
/*

 */
}
