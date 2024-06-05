package com.xjc.code.security.service;




import com.xjc.code.security.domain.SysRole;

import java.util.List;

public interface RoleService {

    public void save(SysRole role);

    public List<SysRole> findAll();

}
