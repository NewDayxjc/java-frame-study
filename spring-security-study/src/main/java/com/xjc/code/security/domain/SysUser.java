package com.xjc.code.security.domain;

import lombok.Data;

import java.util.List;

@Data
public class SysUser {
    private Integer id;
    private String username;
    private String password;
    private Integer status;
    private List<SysRole> roles;
}
