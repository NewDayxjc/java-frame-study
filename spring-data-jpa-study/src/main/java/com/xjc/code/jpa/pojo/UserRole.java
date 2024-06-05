package com.xjc.code.jpa.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/9/23 14:58
 * @name UserRole
 */
@Entity(name = "UserRole")
@Table(name = "user_role")
@Setter
@Getter
@NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userRoleId;
    private Integer userId;
    private Integer roleId;
}
