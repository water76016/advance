package com.daixiaoyu.mongodbdemo;

import com.daixiaoyu.daixiaoyucommon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-10-27 01:19
 **/
@Service
public class UserMongodbServiceImpl implements UserMongodbService{

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void insertUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public void deleteUser(String id) {
        User user = mongoTemplate.findById(id, User.class);
        if (user != null){
            mongoTemplate.remove(user);
        }
    }

    @Override
    public User getUserById(String id) {
        User user = mongoTemplate.findById(id, User.class);
        return user;
    }
}
