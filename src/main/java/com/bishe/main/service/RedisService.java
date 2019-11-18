package com.bishe.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Kirito
 * @Date 2019/8/20 22:28
 * redis Service类
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value){
        boolean result = false;
        try{
            ValueOperations<Serializable, Object> operations =
                    redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @param expireTime    有效时间
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime){
        boolean result = false;
        try{
            ValueOperations<Serializable, Object> operations =
                    redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.MINUTES);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 批量删除key对应的value
     * 【String...表示形参可以是一个也可以是多个，可以充当数组使用】
     * @param keys
     */
    public void remove(final String... keys){
        for(String key : keys){
            remove(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern
     */
    public void removePattern(final String pattern){
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if(keys.size() > 0){
            redisTemplate.delete(keys);
        }
    }

    /**
     *  删除key对应的value
     * @param key
     */
    public void remove(final String key){
        if(exists(key)){
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key){
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 哈希添加
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(String key, Object hashKey){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * 列表插入
     * @param key
     * @param value
     * @return
     */
    public long lPush(String key, Object value){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.rightPush(key, value);
    }

    /**
     * 列表范围获取
     * @param key
     * @param start     开始索引
     * @param end       结束索引
     * @return
     */
    public List<Object> lRange(String key, long start, long end){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(key, start, end);
    }

    /**
     * 集合添加
     * @param key
     * @param value
     * @return
     */
    public long sAdd(String key, Object value){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.add(key, value);
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param scoure
     * @return
     */
    public boolean zAdd(String key, Object value, double scoure){
        ZSetOperations<String, Object> zSet = redisTemplate.opsForZSet();
        return zSet.add(key, value, scoure);
    }

    /**
     * 有序集合获取
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<Object> rangeByScoure(String key, double start, double end){
        ZSetOperations<String, Object> zSet = redisTemplate.opsForZSet();
        return zSet.rangeByScore(key, start, end);
    }
}
