package com.xjc.oss.controller;

import com.xjc.oss.service.OssService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/10/24 15:53
 * @name OssController
 */
@RestController
@RequestMapping("/oss")
public class OssController {
    @Resource
    private OssService ossService;
    @GetMapping
    public void ossString(){
        ossService.uploadString();
    }
}

