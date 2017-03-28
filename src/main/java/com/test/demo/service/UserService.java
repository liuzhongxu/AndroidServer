package com.test.demo.service;

import com.test.demo.po.User;

/**
 * Created by 丁红玉 on 2017/3/10.
 */

public interface UserService {
	public  int insertUser(User user) throws Exception;

	public User selectUserByName(User user) throws Exception;

	public int updateByPrimaryKeySelective(User user) throws Exception;




}
