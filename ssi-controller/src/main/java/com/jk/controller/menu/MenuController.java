/** 
 * <pre>项目名称:ssi-controller 
 * 文件名称:MenuController.java 
 * 包名:com.jk.controller.menu 
 * 创建日期:2017年7月29日上午8:47:18 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;
import com.jk.service.menu.MenuService;

/** 
 * <pre>项目名称：ssi-controller    
 * 类名称：MenuController    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月29日 上午8:47:18    
 * 修改人：王冬   
 * 修改时间：2017年7月29日 上午8:47:18    
 * 修改备注：       
 * @version </pre>    
 */

@Controller
@RequestMapping("/menu/")
public class MenuController {
	
	@Resource
	private MenuService menuService;
	
	@RequestMapping("toMenuListPage")
	public String toMenuListPage(){
		
		return"menu/menu_list";
	}
	
	@RequestMapping("selectMenuListJson")
	@ResponseBody
	public List<MenuResponse> selectMenuListJson(MenuRequest menuRequest) {
		List<MenuResponse> menuList = menuService.selectMenuListJson(menuRequest);
		return menuList;
	}
	
	@RequestMapping("toAddMenuPage")
	String toAddMenuPage(Model m) {
		//查询一级菜单列表，展示到添加页面
		List<MenuResponse> menuList = menuService.selectFirstMenuList(new MenuRequest());
		m.addAttribute("menuList", menuList);
		return "menu/add_menu";
	}
	

	@RequestMapping("insertMenu")
	@ResponseBody
	String insertMenu(MenuRequest menuRequest) {
		menuService.insertMenu(menuRequest);
		return "{}";
	}
	
}
