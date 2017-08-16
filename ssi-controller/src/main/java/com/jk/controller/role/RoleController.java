/** 
 * <pre>项目名称:ssi-controller 
 * 文件名称:RoleController.java 
 * 包名:com.jk.controller.role 
 * 创建日期:2017年7月27日下午7:18:48 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.controller.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;
import com.jk.entity.role.RoleRequest;
import com.jk.entity.role.RoleResponse;

import com.jk.service.role.RoleService;

/** 
 * <pre>项目名称：ssi-controller    
 * 类名称：RoleController    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月27日 下午7:18:48    
 * 修改人：王冬   
 * 修改时间：2017年7月27日 下午7:18:48    
 * 修改备注：       
 * @version </pre>    
 */

@Controller
@RequestMapping("/role/")
public class RoleController {
	
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("selectTreeListJson")
	@ResponseBody
	public List<Map<String , Object>> selectTreeListJson(MenuRequest menuRequest){
		
		List<Map<String , Object>> treeList =roleService.selectTreeListJson(menuRequest);
		
		return treeList;
	}
	
	@RequestMapping("insertRoleMenuList")
	@ResponseBody
	String insertRoleMenuList(@RequestBody List<MenuRequest> menuRequestList) {
		roleService.insertRoleMenuList(menuRequestList);
		return "{}";
	}
	
	
	@RequestMapping("toRoleMenuPage")
	String toRoleMenuPage(Model m, RoleRequest roleRequest) {
		m.addAttribute("roleID", roleRequest.getRoleID());
		return "role/role_menu";
	}
	
	
	@RequestMapping("selectRoleMenuListJson")
	@ResponseBody
	List<MenuResponse> selectRoleMenuListJson(MenuRequest menuRequest) {
		List<MenuResponse> menuList = roleService.selectRoleMenuListJson(menuRequest);
		return menuList;
	}
	
	
	@RequestMapping("selectRoleListJson")
	@ResponseBody
	Map<String, Object> selectRoleListJson(String pageNumber, RoleRequest roleRequest) {
		//查询总条数
		int totalCount = roleService.selectRoleCount(roleRequest);
		roleRequest.setTotalCount(totalCount);
		if (null == pageNumber || "".equals(pageNumber.trim())) {
			pageNumber = "1";
		}
		roleRequest.setPageIndex(Integer.valueOf(pageNumber));
		//计算分页信息
		roleRequest.calculate();
		//查询列表
		List<RoleResponse> roleList = roleService.selectRoleList(roleRequest);
		//封装结果
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalCount);
		map.put("rows", roleList);
		return map;
	}
	
	
	@RequestMapping("toRoleList")
	public String toRoleList(){
		
		
		return "/role/role_list";
	}
	
	

}
