package com.xjc.jpa.application;

import com.xjc.jpa.domain.pojo.User;
import com.xjc.jpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.crypto.spec.PSource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2020/9/22 19:48
 * @name UserService
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public void test(){
        List<User> users = userRepository.userList(23);
//        List<User> users = userRepository.findAll();
        for (User user : users) {
            LocalDateTime date = user.getDate();
            int second = user.getDate().getSecond();
            System.out.println(second);
            System.out.println(date);
            System.out.println(user.toString());
        }
    }
}
