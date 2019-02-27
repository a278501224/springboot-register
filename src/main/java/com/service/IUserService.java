package com.service;

import com.bean.User;

/**
 * @author cherry
 * @version 1.0.0
 * @since 
 * 创建时间：2019年2月16日
 * 功能描述：
 * 官方网站：www.cindy.com
 * 邮箱地址：yichaotang@qq.com
 */
public interface IUserService {
	/**
	 * 新用户的数据
	 * @param user 新的用户数据
	 * @return 新增加的数据的ID
	 */
	Integer register(User user);
	
	/**
	 * 检查用户名在数据表中是否存在
	 * @param username	用户名
	 * @return	如果存在匹配的用户名返回true,没有返回false
	 */
	boolean checkUsernameExists(String username);
	
	/**
	 * 检查手机号在数据表中是否存在
	 * @param phone	手机号
	 * @return	如果存在匹配的手机号返回true，没有返回false
	 */
	boolean checkPhoneExists(String phone);
	
	/**
	 * 检查邮箱地址在数据表中是否存在
	 * @param email 邮箱地址
	 * @return 如果存在匹配的邮箱地址返回true，没有返回false
	 */
	boolean checkEmailExists(String email);
	
	/**
	 * 用户数据
	 * @param username	用户名
	 * @param password	密码
	 * @return	如果存在匹配的用户名和密码返回true，没有返回false
	 */
	boolean checkLoginExists(String username,String password);
	
}
