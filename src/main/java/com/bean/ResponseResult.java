package com.bean;

import java.io.Serializable;

/**
 * @author cherry
 * @version 1.0.0
 * @since 
 * 创建时间：2019年2月21日
 * 功能描述：返回结果实体类
 * 官方网站：www.cindy.com
 * 邮箱地址：yichaotang@qq.com
 */
public class ResponseResult<T> implements Serializable{
	private static final long serialVersionUID = 2064888473966584589L;
	//返回状态码
	private Integer respCode;
	//返回信息
	private String respMsg;
	private T data;
	
	public ResponseResult() {
		super();
	}
	
	public ResponseResult(Integer respCode, String respMsg) {
		super();
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public ResponseResult(Integer respCode, String respMsg, T data) {
		super();
		this.respCode = respCode;
		this.respMsg = respMsg;
		this.data = data;
	}

	public Integer getRespCode() {
		return respCode;
	}

	public void setRespCode(Integer respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseResult [respCode=" + respCode + ", respMsg=" + respMsg + ", data=" + data + "]";
	}
	
	
	
}
