/** 
 * <pre>项目名称:maven-web-test3 
 * 文件名称:User.java 
 * 包名:com.jk.entity.user 
 * 创建日期:2017年7月19日下午5:19:30 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity.user;

import java.io.Serializable;

import commen.util.Page;

/** 
 * <pre>项目名称：maven-web-test3    
 * 类名称：User    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月19日 下午5:19:30    
 * 修改人：王冬   
 * 修改时间：2017年7月19日 下午5:19:30    
 * 修改备注：       
 * @version </pre>    
 */
public class User extends Page implements Serializable{
	
	private Integer userID;
	
	private String userName;
	
	private String userPwd;
	
	private Integer loginFailNum;
	
	private Integer loginFailDate;
	
	

	public Integer getLoginFailNum() {
		return loginFailNum;
	}

	public void setLoginFailNum(Integer loginFailNum) {
		this.loginFailNum = loginFailNum;
	}

	public Integer getLoginFailDate() {
		return loginFailDate;
	}

	public void setLoginFailDate(Integer loginFailDate) {
		this.loginFailDate = loginFailDate;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}
