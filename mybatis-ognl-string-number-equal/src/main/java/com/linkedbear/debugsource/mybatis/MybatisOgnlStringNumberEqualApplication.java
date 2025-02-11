package com.linkedbear.debugsource.mybatis;

import com.linkedbear.debugsource.mybatis.entity.User;
import com.linkedbear.debugsource.mybatis.mapper.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MybatisOgnlStringNumberEqualApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(MybatisOgnlStringNumberEqualApplication.class, args);
		UserMapper userMapper = ctx.getBean(UserMapper.class);
		List<User> users = userMapper.findAll(null, null, null);
		users.forEach(System.out::println);
		System.out.println("---------------");
		users = userMapper.findAll(null, null, 0);
		users.forEach(System.out::println);
		System.out.println("---------------");
		users = userMapper.findAll(null, "0", null);
		users.forEach(System.out::println);
	}
}
