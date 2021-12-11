package com.github.mg0324.madmin.core.util;

import cn.hutool.cache.impl.TimedCache;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CacheUtil {
    private TimedCache cache;

    @PostConstruct
    public void init(){
        cache = cn.hutool.cache.CacheUtil.newTimedCache(5 * 60 * 1000);
    }

    public void setCache(String key,Object value){
        cache.put(key,value);
    }

    public void setCache(String key,Object value,int timeout){
        cache.put(key,value,timeout);
    }

    public Object getCache(String key){
        return cache.get(key);
    }

    public void removeCache(String key){
        cache.remove(key);
    }

}
