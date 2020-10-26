package com.xjc.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/10/13 17:21
 * @name AppController
 */
@RestController
@RequestMapping("/app/api")
public class AppController {
    @GetMapping("hello")
    public String hello() {
        return "hello, app";
    }
}
