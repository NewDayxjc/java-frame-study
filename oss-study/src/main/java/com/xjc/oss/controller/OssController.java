package com.xjc.oss.controller;

import com.xjc.oss.service.OssService;
import com.xjc.oss.service.PostObjectService;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    private PostObjectService postObjectService;

    @PostMapping(value = "/ossString")
    public void ossString(){
        ossService.uploadString();
    }
    //uploadByteArray

    @PostMapping(value = "/ossByte")
    public void ossByte(){
        ossService.uploadByteArray();
    }

    @PostMapping(value = "/postObject")
    public void postObject() throws Exception {
        postObjectService.PostObject();
    }

    @PostMapping(value ="/downFile")
    public void downFile(){
        ossService.downloadFile();
    }
}

