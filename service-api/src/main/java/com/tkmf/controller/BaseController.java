package com.tkmf.controller;

import com.tkmf.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Component
public class BaseController {
public static final String MOBILE_SMSCODE = "mobile:smscode:";
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    protected RedisOperator redisOperator;

    public Map<String,String> getErrors(BindingResult bindingResult) {
        Map<String,String> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(fieldError -> {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
        }
        return errors;
    }
}
