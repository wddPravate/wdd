package com.jk.dao.role;

import java.util.List;
import java.util.Map;

import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;
import com.jk.entity.role.RoleRequest;
import com.jk.entity.role.RoleResponse;

public interface RoleDao {

	int selectRoleCount(RoleRequest roleRequest);

	List<RoleResponse> selectRoleList(RoleRequest roleRequest);

	List<MenuResponse> selectRoleMenuListJson(MenuRequest menuRequest);

	void deleteAllRoleMenuByRoleID(MenuRequest menuRequest);

	void insertRoleMenuList(List<MenuRequest> menuRequestList);

	List<Map<String, Object>> selectTreeListJson(MenuRequest menuRequest);
	

}
