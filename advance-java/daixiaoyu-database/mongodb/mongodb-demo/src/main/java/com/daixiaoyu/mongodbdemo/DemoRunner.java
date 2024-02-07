package com.daixiaoyu.mongodbdemo;

import com.daixiaoyu.daixiaoyucommon.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-11-04 16:52
 **/
@Component
@Slf4j
public class DemoRunner implements CommandLineRunner {
    @Autowired
    private UserMongodbService userMongodbService;

    @Override
    public void run(String... args) throws Exception {
        //插入一条数据
        User user = new User();
        user.setId("123");
        user.setName("小明");
        user.setAge(18);
        user.setSex("男");

        userMongodbService.insertUser(user);
        //查看插入的数据是否存在
        User databaseUser = userMongodbService.getUserById("123");
        log.info("打印查询的数据：{}", databaseUser);

        //将数据进行删除
        userMongodbService.deleteUser("123");
        //查看删除后的数据是否存在
        User delUser = userMongodbService.getUserById("123");
        log.info("打印查询的数据：{}", delUser);
    }
}
