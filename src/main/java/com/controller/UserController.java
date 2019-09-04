package com.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.ResponseResult;
import com.bean.User;
import com.service.IUserService;

/**
 * @author cherry
 * @version 1.0.0
 * @since 创建时间：2019年2月16日
 * 功能描述：
 * 官方网站：yichaotang.cn
 * 邮箱地址：yichaotang@qq.com
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userService")
	private IUserService userSerivce;

	ResponseResult<Void> rr;

	/**
	 * 注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/register")
	public String showRegister() {
		return "register";
	}
	
	/**
	 * 登陆页面
	 * @return
	 */
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index")
	public String showindex() {
		return "index";
	}
	
	/**
	 * 做个demo页面测试bootstrap
	 * @return
	 */
	@RequestMapping("/demo")
	public String showDemo() {
		return "demo";
	}
	
	/**
	 * 校验用户名
	 * 
	 * @param username 用户名
	 * @return
	 */
	@RequestMapping("/checkUserName")
	@ResponseBody
	public ResponseResult<Void> checkUserName(String username) {
		boolean result = userSerivce.checkUsernameExists(username);
		logger.info("校验用户名:" + result);

		// 判断检查结果
		if (result) {
			// 结果为true，用户名已存在
			rr = new ResponseResult<Void>(0, "用户名已被占用");
		} else {
			// 结果为false，用户名不存在
			rr = new ResponseResult<Void>(1, "用户名可以使用");
		}
		return rr;
	}

	/**
	 * 校验手机号
	 * 
	 * @param phone 手机号
	 * @return
	 */
	@RequestMapping("/checkPhone")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		boolean result = userSerivce.checkPhoneExists(phone);
		logger.info("校验手机号:" + result);

		// 判断检查结果
		if (result) {
			// 结果为true,手机号已存在
			rr = new ResponseResult<Void>(0, "手机号已经被注册");
		} else {
			// 结果为false,手机号不存在
			rr = new ResponseResult<Void>(1, "手机号可以正常使用");
		}
		return rr;
	}

	/**
	 * 校验邮箱
	 * 
	 * @param email 邮箱地址
	 * @return
	 */
	@RequestMapping("/checkEmail")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
		boolean result = userSerivce.checkEmailExists(email);
		logger.info("校验邮箱地址:" + result);

		// 判断检查结果
		if (result) {
			// 结果为true,邮箱地址已存在
			rr = new ResponseResult<Void>(0, "邮箱地址已经被注册");
		} else {
			// 结果为false,邮箱地址不存在
			rr = new ResponseResult<Void>(1, "邮箱地址可以正常使用");
		}
		return rr;
	}
	
	/**
	 * 用户注册提交
	 * @param user 用户信息
	 * @return
	 */
	@RequestMapping("/handleRegister")
	@ResponseBody
	public ResponseResult<Void> register(User user){
			Integer result = userSerivce.register(user);
			if (result==0) {
				rr = new ResponseResult<Void>(0,"用户名已经存在");
				logger.info("新用户注册失败");
			}else {
				rr =new ResponseResult<Void>(1,"注册成功");
				logger.info("新用户注册成功");
			}
		return rr;
	}
	
	@RequestMapping("/handleLogin")
	@ResponseBody
	public ResponseResult<Void> login(User user){
		boolean result = userSerivce.checkLoginExists(user.getUsername(), user.getPassword());
		logger.info("用户名和密码匹配是否成功："+result);
		if(result) {
			rr=new ResponseResult<Void>(1,"登陆成功");
			logger.info("账号登陆成功");
		}else {
			rr = new ResponseResult<Void>(0,"登陆失败");
			logger.info("账号登陆失败");
		}
		return rr;
	}
}
