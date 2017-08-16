/** 
 * <pre>项目名称:ssi-entity 
 * 文件名称:MenuResponse.java 
 * 包名:com.jk.entity.menu 
 * 创建日期:2017年7月27日下午10:37:15 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity.menu;

/** 
 * <pre>项目名称：ssi-entity    
 * 类名称：MenuResponse    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月27日 下午10:37:15    
 * 修改人：王冬   
 * 修改时间：2017年7月27日 下午10:37:15    
 * 修改备注：       
 * @version </pre>    
 */
public class MenuResponse extends Menu {
	
	private int id;
	
	
	
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

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	
	private String name;
	
	private boolean checked;
	
	

}
