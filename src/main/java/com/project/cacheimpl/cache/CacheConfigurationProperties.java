package com.project.cacheimpl.cache;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Rabina Shrestha
 * @EmaiL rabina.shrestha@f1soft.com
 */
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class CacheConfigurationProperties {

    private long timeoutSeconds = 60000;
    private int redisPort = 6379;
    private String redisHost = "localhost";
    // Mapping of cacheNames to expira-after-write timeout in seconds
    private Map<String, Long> cacheExpirations = new HashMap<>();
}
