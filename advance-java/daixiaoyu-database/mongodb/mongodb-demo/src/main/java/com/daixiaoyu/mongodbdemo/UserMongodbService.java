package com.daixiaoyu.mongodbdemo;

import com.daixiaoyu.daixiaoyucommon.entity.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-10-27 01:17
 **/
public interface UserMongodbService {
    void insertUser(User user);

    void deleteUser(String id);

    User getUserById(String id);
}
