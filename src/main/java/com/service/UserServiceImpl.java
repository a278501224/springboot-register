package com.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.controller.UserController;
import com.mapper.UserMapper;

/**
 * @author cherry
 * @version 1.0.0
 * @since 
 * 创建时间：2019年2月16日
 * 功能描述：
 * 官方网站：yichaotang.cn
 * 邮箱地址：yichaotang@qq.com
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="userMapper")
	UserMapper userMapper;
	//用户名已被占用
	private static final Integer USERNAME_EXISTS = 0;
	//用户名没有被占用
	private static final Integer USERNAME_ISNOTEXISTS=1;

	@Override
	public Integer register(User user) {
		//判断用户名是否被注册
		if(checkUsernameExists(user.getUsername())) {
			logger.info("用户名已经被占用，返回信息:"+USERNAME_EXISTS);
			return USERNAME_EXISTS;
		}else {
			logger.info("用户名没有被占用,开始新增");
			userMapper.insertUser(user);
			logger.info("注册成功");
			//返回新数据的ID
			//return user.getId();
			return USERNAME_ISNOTEXISTS;
		}
	}
	
	/**
	 * 根据用户名查询用户信息
	 * @param username	用户名
	 * @return
	 */
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}
	
	public boolean checkUsernameExists(String username) {
		return findUserByUsername(username)!=null;
	}
	
	
	public boolean checkPhoneExists(String phone) {
		return userMapper.getCountByPhone(phone)>0;
	}
	
	public boolean checkEmailExists(String email) {
		return userMapper.getCountByEmail(email)>0;
	}

	@Override
	public boolean checkLoginExists(String username, String password) {
		return userMapper.getCountByUsernameAndPassword(username, password)==1;
	}

}
