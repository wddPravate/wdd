/** 
 * <pre>项目名称:ssi-entity 
 * 文件名称:Tree.java 
 * 包名:com.jk.entity.user 
 * 创建日期:2017年7月25日上午9:01:07 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity.user;

/** 
 * <pre>项目名称：ssi-entity    
 * 类名称：Tree    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月25日 上午9:01:07    
 * 修改人：王冬   
 * 修改时间：2017年7月25日 上午9:01:07    
 * 修改备注：       
 * @version </pre>    
 */
public class Tree {

	private Integer id;
	
	private Integer pid;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
