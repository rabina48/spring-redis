//package com.project.cacheimpl.cache;
//
//import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
//import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author Rabina Shrestha
// * @EmaiL rabina.shrestha@f1soft.com
// */
//
//@Configuration
//public class CacheConfiguration {
//
//    CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
//    return  new  ConcurrentCustomizer();
//
//    }
//
//    class  ConcurrentCustomizer implements  CacheManagerCustomizer<ConcurrentMapCacheManager>{
//
//        @Override
//        public void customize(ConcurrentMapCacheManager cacheManager) {
//            cacheManager.setAllowNullValues(false);
//            cacheManager.setStoreByValue(true);
//
//            System.out.println("customizer invoked");
//
//        }
//    }
//}
