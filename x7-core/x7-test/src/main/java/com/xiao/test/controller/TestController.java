package com.xiao.test.controller;

import com.xiao.common.enums.AccessEnum;
import com.xiao.common.exception.RestfulException;
import com.xiao.test.config.SecurityConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 晓
 */

@RestController
@RequestMapping("test")
@Api(tags = "测试操作手册")
@Slf4j
public class TestController {

    @Autowired
    private SecurityConfig securityConfig;

    @GetMapping("/")
    @ApiOperation(value = "测试")
    public String testApp(){
        return "ok";
    }

    @GetMapping("/swagger")
    @ApiOperation(value = "swagger测试")
    public String testSwagger() {
        if(!securityConfig.checkRole("ROLE_ADMIN")){
            throw new RestfulException(AccessEnum.ACCESS_FAIL);
        }
        return "ok"+" "+ securityConfig.getAuthenticationName();
    }

}
