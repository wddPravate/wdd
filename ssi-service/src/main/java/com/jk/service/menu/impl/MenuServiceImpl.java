/** 
 * <pre>项目名称:ssi-service 
 * 文件名称:MenuServiceImpl.java 
 * 包名:com.jk.service.menu.impl 
 * 创建日期:2017年7月29日上午8:50:27 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.service.menu.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jk.dao.menu.MenuDao;
import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;
import com.jk.service.menu.MenuService;

/** 
 * <pre>项目名称：ssi-service    
 * 类名称：MenuServiceImpl    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月29日 上午8:50:27    
 * 修改人：王冬   
 * 修改时间：2017年7月29日 上午8:50:27    
 * 修改备注：       
 * @version </pre>    
 */

@Service
public class MenuServiceImpl implements MenuService{
	@Resource
	private MenuDao menuDao;

	@Override
	public List<MenuResponse> selectMenuListJson(MenuRequest menuRequest) {
		return menuDao.selectMenuListJson(menuRequest);
	}

	@Override
	public List<MenuResponse> selectFirstMenuList(MenuRequest menuRequest) {
		return menuDao.selectFirstMenuList(menuRequest);
	}
	
	@Override
	public void insertMenu(MenuRequest menuRequest) {
		//判断是否是模块
		if (0 == menuRequest.getPid()) {
			menuRequest. setParent(true);
		}
		menuDao.insertMenu(menuRequest);
	}

}
