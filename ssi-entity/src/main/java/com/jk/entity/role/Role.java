/** 
 * <pre>项目名称:ssi-entity 
 * 文件名称:Role.java 
 * 包名:com.jk.entity.role 
 * 创建日期:2017年7月26日上午10:29:42 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity.role;

import java.io.Serializable;

import commen.util.Page;

/** 
 * <pre>项目名称：ssi-entity    
 * 类名称：Role    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月26日 上午10:29:42    
 * 修改人：王冬   
 * 修改时间：2017年7月26日 上午10:29:42    
 * 修改备注：       
 * @version </pre>    
 */
public class Role extends Page implements Serializable{

	private Integer roleID;
	
	private String roleName;
	
	private String roleDesc;
	
	

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
