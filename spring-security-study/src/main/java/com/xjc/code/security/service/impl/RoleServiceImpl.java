package com.xjc.code.security.service.impl;



import com.xjc.code.security.dao.RoleDao;
import com.xjc.code.security.domain.SysRole;
import com.xjc.code.security.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;
    @Override
    public void save(SysRole role) {
        roleDao.save(role);
    }

    @Override
    public List<SysRole> findAll() {
        return roleDao.findAll();
    }
}
