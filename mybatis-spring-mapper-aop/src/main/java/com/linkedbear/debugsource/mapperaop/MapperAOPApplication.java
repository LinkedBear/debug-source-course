package com.linkedbear.debugsource.mapperaop;

import com.linkedbear.debugsource.mapperaop.entity.User;
import com.linkedbear.debugsource.mapperaop.mapper.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MapperAOPApplication {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        UserMapper userMapper = ctx.getBean(UserMapper.class);
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);
        
//        User user = new User();
//        user.setName("test");
//        user.setTel("111");
//        userMapper.save(user);
    }
}
