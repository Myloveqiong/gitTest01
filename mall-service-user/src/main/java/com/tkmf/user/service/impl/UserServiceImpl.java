package com.tkmf.user.service.impl;

import com.tkmf.pojo.User;
import com.tkmf.user.mapper.UserMapper;
import com.tkmf.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        User user = userMapper.selectOneByExample(example);
        return user;
    }
}
