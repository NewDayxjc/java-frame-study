package com.xjc.security.service;



import com.xjc.security.domain.SysRole;

import java.util.List;

public interface RoleService {

    public void save(SysRole role);

    public List<SysRole> findAll();

}
