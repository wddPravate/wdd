/** 
 * <pre>项目名称:maven-web-test3 
 * 文件名称:UserRequest.java 
 * 包名:com.jk.entity.user 
 * 创建日期:2017年7月19日下午5:34:01 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity.user;

/** 
 * <pre>项目名称：maven-web-test3    
 * 类名称：UserRequest    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月19日 下午5:34:01    
 * 修改人：王冬   
 * 修改时间：2017年7月19日 下午5:34:01    
 * 修改备注：       
 * @version </pre>    
 */
public class UserRequest extends User{
	private String userCodeImg;
	
	private String sysCodeImg;
	
	

	public String getUserCodeImg() {
		return userCodeImg;
	}

	public void setUserCodeImg(String userCodeImg) {
		this.userCodeImg = userCodeImg;
	}

	public String getSysCodeImg() {
		return sysCodeImg;
	}

	public void setSysCodeImg(String sysCodeImg) {
		this.sysCodeImg = sysCodeImg;
	}
}
