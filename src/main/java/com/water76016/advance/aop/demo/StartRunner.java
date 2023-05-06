package com.water76016.advance.aop.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-05-07 00:45
 **/
@Component
public class StartRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("正在执行aop demo");
        User user = new User();
        user.setId("1");
        user.setName("张三");
        user.setAge(18);
        userService.saveUser(user);
        System.out.println("aop demo执行结束");
    }
}
