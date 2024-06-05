package com.xjc.code.jpa.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/9/23 14:53
 * @name Role
 */
@Table(name = "role")
@Entity(name = "role")
@Getter
@Setter
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;
    private String roleName;
    private String roleAuthority;

    public Role() {
    }



    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleAuthority() {
        return roleAuthority;
    }

    public void setRoleAuthority(String roleAuthority) {
        this.roleAuthority = roleAuthority;
    }
}
