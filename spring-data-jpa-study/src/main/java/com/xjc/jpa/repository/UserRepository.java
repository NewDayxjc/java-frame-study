package com.xjc.jpa.repository;

import com.xjc.jpa.domain.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/9/22 11:48
 * @name UserRepository
 */
@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    @Query(value="select * from user u where  u.age=?1 ",nativeQuery=true)
    public List<User> userList(Integer age);
}
