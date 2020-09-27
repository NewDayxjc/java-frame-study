package com.xjc.jpa.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    public void test(){
        userService.test();
    }

    public void generate(){
        userService.test();
    }
}