package com.xjc.oss.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.xjc.oss.config.OssConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/10/24 15:54
 * @name OssService
 */
@Service
public class OssService {
    @Qualifier

    private OssConfig ossConfig;

    public void uploadString(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4FsZrDy3KUBkwyrTquZd";
        String accessKeySecret = "8LnxuLNlIgGZ7ThVM7E5WYze9SUwAy";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
// 创建PutObjectRequest对象。
        String content = "Hello OSS";
// <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        PutObjectRequest putObjectRequest = new PutObjectRequest("xjc-character", "user", new ByteArrayInputStream(content.getBytes()));

// 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
// ObjectMetadata metadata = new ObjectMetadata();
// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
// metadata.setObjectAcl(CannedAccessControlList.Private);
// putObjectRequest.setMetadata(metadata);

// 上传字符串。
        ossClient.putObject(putObjectRequest);

// 关闭OSSClient。
        ossClient.shutdown();
    }

    public void uploadByteArray(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "<yourAccessKeyId>";
        String accessKeySecret = "<yourAccessKeySecret>";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId,accessKeySecret);

// 上传Byte数组。
        byte[] content = "Hello OSS".getBytes();
        ossClient.putObject("<yourBucketName>", "<yourObjectName>", new ByteArrayInputStream(content));

// 关闭OSSClient。
        ossClient.shutdown();
    }
}
