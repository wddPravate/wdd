/** 
 * <pre>项目名称:ssi-dao 
 * 文件名称:RoleDaoImpl.java 
 * 包名:com.jk.dao.role.impl 
 * 创建日期:2017年7月27日下午7:33:07 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.dao.role.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.jk.dao.role.RoleDao;
import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;
import com.jk.entity.role.RoleRequest;
import com.jk.entity.role.RoleResponse;

/** 
 * <pre>项目名称：ssi-dao    
 * 类名称：RoleDaoImpl    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月27日 下午7:33:07    
 * 修改人：王冬   
 * 修改时间：2017年7月27日 下午7:33:07    
 * 修改备注：       
 * @version </pre>    
 */

@Repository
public class RoleDaoImpl extends SqlMapClientDaoSupport implements RoleDao {

	@Override
	public int selectRoleCount(RoleRequest roleRequest) {
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject("role.selectRoleCount", roleRequest);
	}

	@Override
	public List<RoleResponse> selectRoleList(RoleRequest roleRequest) {
		
		
		return this.getSqlMapClientTemplate().queryForList("role.selectRoleList", roleRequest);
	}

	@Override
	public List<MenuResponse> selectRoleMenuListJson(MenuRequest menuRequest) {
		return this.getSqlMapClientTemplate().queryForList("role.selectRoleMenuListJson", menuRequest);
	}

	@Override
	public void deleteAllRoleMenuByRoleID(MenuRequest menuRequest) {
		
		this.getSqlMapClientTemplate().delete("role.deleteAllRoleMenuByRoleID", menuRequest);
		
	}

	@Override
	public void insertRoleMenuList(final List<MenuRequest> menuRequestList) {
		
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {


			@Override
			public Object doInSqlMapClient(SqlMapExecutor sqlMap) throws SQLException {
				sqlMap.startBatch();
				for (MenuRequest menuRequest : menuRequestList) {
					sqlMap.insert("role.insertRoleMenu", menuRequest);
				}
				sqlMap.executeBatch();
				return null;
			}
		});
		
	}

	@Override
	public List<Map<String, Object>> selectTreeListJson(MenuRequest menuRequest) {
		return this.getSqlMapClientTemplate().queryForList("role.selectTreeListJson", menuRequest);
	}

	
}
