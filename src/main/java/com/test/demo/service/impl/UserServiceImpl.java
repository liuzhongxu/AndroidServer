package com.test.demo.service.impl;

import com.test.demo.mapper.UserMapper;
import com.test.demo.po.User;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by 丁红玉 on 2017/3/10.
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper; //spring框架配置了注解，自动注入
	
	@Override
	public int insertUser(User user) throws Exception {
		// TODO Auto-generated method stub

		return userMapper.insert(user);
	}

	@Override
	public User selectUserByName(User user) throws Exception {
		return userMapper.selectUserByName(user);
	}

	@Override
	public int updateByPrimaryKeySelective(User user) throws Exception {
		return userMapper.updateByPrimaryKeySelective(user);
	}

}
