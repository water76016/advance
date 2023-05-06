package com.water76016.advance.aop.demo;

import org.springframework.stereotype.Service;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-05-07 00:18
 **/
@Service
public class UserServiceImpl implements UserService{
    @Override
    public User saveUser(User user) {
        System.out.println("正在执行保存用户信息接口，且调用成功");
        return user;
    }
}
