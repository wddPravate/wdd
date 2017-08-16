/** 
 * <pre>项目名称:ssi-entity 
 * 文件名称:RoleResponse.java 
 * 包名:com.jk.entity.role 
 * 创建日期:2017年7月26日上午10:34:29 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity.role;

/** 
 * <pre>项目名称：ssi-entity    
 * 类名称：RoleResponse    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月26日 上午10:34:29    
 * 修改人：王冬   
 * 修改时间：2017年7月26日 上午10:34:29    
 * 修改备注：       
 * @version </pre>    
 */
public class RoleResponse extends Role{
	
	private int id;
	
	private String name;
	
	private int pid;
	
	private boolean checked;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	

}
