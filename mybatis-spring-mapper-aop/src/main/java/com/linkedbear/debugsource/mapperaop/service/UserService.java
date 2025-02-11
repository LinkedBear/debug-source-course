package com.linkedbear.debugsource.mapperaop.service;

import com.linkedbear.debugsource.mapperaop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
}
