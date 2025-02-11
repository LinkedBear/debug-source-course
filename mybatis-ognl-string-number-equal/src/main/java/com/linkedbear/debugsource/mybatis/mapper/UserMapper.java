package com.linkedbear.debugsource.mybatis.mapper;

import com.linkedbear.debugsource.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    
    List<User> findAll(@Param("name") String name, @Param("statusStr") String statusStr, @Param("status") Integer status);
}
