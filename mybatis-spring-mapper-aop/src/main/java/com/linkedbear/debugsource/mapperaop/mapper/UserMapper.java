package com.linkedbear.debugsource.mapperaop.mapper;

import com.linkedbear.debugsource.mapperaop.aop.OperationLog;
import com.linkedbear.debugsource.mapperaop.base.BaseMapper;
import com.linkedbear.debugsource.mapperaop.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    
    @OperationLog(content = "查询数据")
    List<User> findAll();
}
