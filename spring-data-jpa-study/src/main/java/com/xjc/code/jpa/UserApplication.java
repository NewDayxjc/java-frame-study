package com.xjc.code.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/9/22 20:10
 * @name UserApplication
 */
@SpringBootApplication
@EnableJpaRepositories
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }

}
