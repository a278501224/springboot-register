package com.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cherry
 * @version 1.0.0
 * @since 
 * 创建时间：2019年2月15日
 * 功能描述：用户实体类
 * 官方网站：www.cindy.com
 * 邮箱地址：yichaotang@qq.com
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -281160726771996831L;
	Integer id;
	String username;
	String password;
	String phone;
	String email;
	Date crtTime;
	Date updTime;
	public User() {
		super();
	}
	public User(Integer id, String username, String password, String phone, String email, Date crtTime, Date updTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.crtTime = crtTime;
		this.updTime = updTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCrtTime() {
		return crtTime;
	}
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	public Date getUpdTime() {
		return updTime;
	}
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", crtTime=" + crtTime + ", updTime=" + updTime + "]";
	}
	
	
}
