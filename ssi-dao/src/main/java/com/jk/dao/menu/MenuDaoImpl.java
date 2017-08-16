/** 
 * <pre>项目名称:ssi-dao 
 * 文件名称:MenuDaoImpl.java 
 * 包名:com.jk.dao.menu 
 * 创建日期:2017年7月29日上午8:56:00 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.dao.menu;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;

/** 
 * <pre>项目名称：ssi-dao    
 * 类名称：MenuDaoImpl    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月29日 上午8:56:00    
 * 修改人：王冬   
 * 修改时间：2017年7月29日 上午8:56:00    
 * 修改备注：       
 * @version </pre>    
 */
@Repository
public class MenuDaoImpl extends SqlMapClientDaoSupport implements MenuDao {

	@Override
	public List<MenuResponse> selectMenuListJson(MenuRequest menuRequest) {
		return this.getSqlMapClientTemplate().queryForList("menu.selectMenuListJson", menuRequest);
	}

	@Override
	public List<MenuResponse> selectFirstMenuList(MenuRequest menuRequest) {
		return this.getSqlMapClientTemplate().queryForList("menu.selectFirstMenuList", menuRequest);
	}

	@Override
	public void insertMenu(MenuRequest menuRequest) {
		this.getSqlMapClientTemplate().insert("menu.insertMenu", menuRequest);
	}
	
}
