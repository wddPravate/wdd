/** 
 * <pre>项目名称:ssi-entity 
 * 文件名称:MenuRequest.java 
 * 包名:com.jk.entity.menu 
 * 创建日期:2017年7月27日下午10:35:27 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity.menu;

/** 
 * <pre>项目名称：ssi-entity    
 * 类名称：MenuRequest    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月27日 下午10:35:27    
 * 修改人：王冬   
 * 修改时间：2017年7月27日 下午10:35:27    
 * 修改备注：       
 * @version </pre>    
 */
public class MenuRequest extends Menu{
	
	private int roleID;
	
	private int userID;

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}


}
