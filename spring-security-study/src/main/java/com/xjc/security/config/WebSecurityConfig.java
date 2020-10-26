package com.xjc.security.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/10/13 10:42
 * @name WebSecurityConfig
 */
//@EnableWebSecurity
public class WebSecurityConfig {
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        inMemoryUserDetailsManager.createUser(User.withDefaultPasswordEncoder().username("user").password("user").roles("ROLE_USER").build());
//        return  inMemoryUserDetailsManager;
//    }

}
