package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by Lenovo on 2017/11/3.
 */
@Repository
public class Dao {
    @Autowired
    RedisTemplate redisTemplate;

    public void set(String key, String value) {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set(key,value);
    }

    public String get(String key) {
        ValueOperations ops = redisTemplate.opsForValue();
        return ops.get(key).toString();
    }

    public void set(User user) {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set(user.getId(),user.getUsername());
    }

    public String get(User user) {
        ValueOperations ops = redisTemplate.opsForValue();
        return  ops.get(user.getId()).toString();
    }
}
