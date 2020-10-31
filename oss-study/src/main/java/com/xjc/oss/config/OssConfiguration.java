package com.xjc.oss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/10/30 14:41
 * @name Configuration
 */
@Configuration
public class OssConfiguration {

    @Bean("ossConfig")
    public OssConfig ossConfig(){
        return new OssConfig();
    }
}
