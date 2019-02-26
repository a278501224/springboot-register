package com.mapper;

import com.bean.User;

/**
 * @author cherry
 * @version 1.0.0
 * @since 
 * 创建时间：2019年2月15日
 * 功能描述：
 * 官方网站：www.cindy.com
 * 邮箱地址：yichaotang@qq.com
 */
public interface UserMapper {
	/**
	 * 增加用户数据
	 * @param user 新的用户数据
	 */
	void insertUser(User user);
	
	/**
	 * 根据用户名查询用户信息
	 * @param username	用户名
	 * @return	与用户名匹配的数据，如果没有匹配，返回null
	 */
	User findUserByUsername(String username);
	
	/**
	 * 获取某手机号对应的数量
	 * @param phone	手机号
	 * @return
	 */
	Integer getCountByPhone(String phone);
	
	/**
	 * 获取某邮箱对应的数量
	 * @param email	邮箱地址
	 * @return
	 */
	Integer getCountByEmail(String email);
	
	
}
