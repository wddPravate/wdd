/** 
 * <pre>项目名称:ssi-service 
 * 文件名称:RoleServiceImpl.java 
 * 包名:com.jk.service.role.impl 
 * 创建日期:2017年7月27日下午7:31:37 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.service.role.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jk.dao.role.RoleDao;
import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;
import com.jk.entity.role.RoleRequest;
import com.jk.entity.role.RoleResponse;
import com.jk.service.role.RoleService;

/** 
 * <pre>项目名称：ssi-service    
 * 类名称：RoleServiceImpl    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月27日 下午7:31:37    
 * 修改人：王冬   
 * 修改时间：2017年7月27日 下午7:31:37    
 * 修改备注：       
 * @version </pre>    
 */


@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	@Override
	public int selectRoleCount(RoleRequest roleRequest) {
		// TODO Auto-generated method stub
		return roleDao.selectRoleCount(roleRequest);
	}

	@Override
	public List<RoleResponse> selectRoleList(RoleRequest roleRequest) {
		
		return roleDao.selectRoleList(roleRequest);
	}

	@Override
	public List<MenuResponse> selectRoleMenuListJson(MenuRequest menuRequest) {
		return roleDao.selectRoleMenuListJson(menuRequest);
	}

	@Override
	public void insertRoleMenuList(List<MenuRequest> menuRequestList) {
		roleDao.deleteAllRoleMenuByRoleID(menuRequestList.get(0));
		roleDao.insertRoleMenuList(menuRequestList);
	}

	@Override
	public List<Map<String, Object>> selectTreeListJson(MenuRequest menuRequest) {
		
		//从redis缓存中获取权限列表
		
		//如果没有获取到，则查询数据库，如果查询到了结果，直接返回
		
		//把查询的结果存一份到redis上
		
		List<Map<String, Object>> treeList = roleDao.selectTreeListJson(menuRequest);
		if(treeList != null && 0 < treeList.size())
		{
			treeList=queryTreeListNodes(treeList,menuRequest);
			
		}else{
			treeList=new ArrayList<Map<String,Object>>();
		}
		
		
		return treeList;
	}

	private List<Map<String, Object>> queryTreeListNodes(List<Map<String, Object>> treeList, MenuRequest menuRequest) {
		for (Map<String, Object> map : treeList) {
			if("0".equals(map.get("pid").toString()))
			{
				Integer pid = Integer.valueOf(map.get("id").toString());
				menuRequest.setPid(pid);
				
				List<Map<String, Object>> queryTreeListNodes = 
						queryTreeListNodes(roleDao.selectTreeListJson(menuRequest), menuRequest);
				map.put("nodes", queryTreeListNodes);
			}
		}
		return treeList;
	}
}
