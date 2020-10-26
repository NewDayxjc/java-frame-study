package com.xjc.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/10/12 17:54
 * @name SecurityApplication
 */
@MapperScan(value = "com.xjc.security.dao")
@SpringBootApplication
@RestController
public class SecurityApplication {
    public static void main(String[] args) {
       SpringApplication.run(SecurityApplication.class,args);
    }

    @GetMapping(value = "/")
    public String hello(){
        return "hello security";
    }
}
