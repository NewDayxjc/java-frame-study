package com.xjc.code.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/10/24 15:47
 * @name Application
 */
@SpringBootApplication
//@ComponentScan("com.xjc.oss.config")
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);
    }
}
