package com.xiao.test.controller;

import com.xiao.common.annotation.OpenSwagger2;
import com.xiao.common.enums.ParamEnum;
import com.xiao.test.config.SecurityConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 晓
 */

@RestController
@RequestMapping("redis")
@Api(tags = "redis操作手册")
@Slf4j
public class RedisOperationController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SecurityConfig securityConfig;


    @GetMapping("/redis/get/{key}")
    @ApiOperation(value = "通过key取redis值")
    @OpenSwagger2
    public String testRedisOperation(@PathVariable String key){
        if(!securityConfig.checkRole("ROLE_ADMIN")){
            throw new RuntimeException(ParamEnum.PARAM_NOT_EMPTY.toString());
        }

        String value = (String) redisTemplate.opsForValue().get(key);
        return  value;
    }
}
