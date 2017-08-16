/** 
 * <pre>项目名称:ssi-entity 
 * 文件名称:Menu.java 
 * 包名:com.jk.entity.menu 
 * 创建日期:2017年7月27日下午10:34:36 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity.menu;

/** 
 * <pre>项目名称：ssi-entity    
 * 类名称：Menu    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月27日 下午10:34:36    
 * 修改人：王冬   
 * 修改时间：2017年7月27日 下午10:34:36    
 * 修改备注：       
 * @version </pre>    
 */
public class Menu {
	
private int menuID;
	
	private String url;
	
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	private String menuName;
	
private boolean isParent;
	
	private int menuType;
	
	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	public int getMenuType() {
		return menuType;
	}

	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	private int pid;


}
