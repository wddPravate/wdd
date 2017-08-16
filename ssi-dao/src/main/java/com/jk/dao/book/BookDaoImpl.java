package com.jk.dao.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.jk.entity.book.Book;
import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;
import com.jk.entity.role.RoleRequest;
import com.jk.entity.user.Tree;
import com.jk.entity.user.UserRequest;
import com.jk.entity.user.UserResponse;

@Repository
public class BookDaoImpl extends SqlMapClientDaoSupport implements BookDao{
	
	public List selectAllBookInFo() {
		
		return getSqlMapClientTemplate().queryForList("book.selectBookList");
	}

	/*
	 * 新增方法
	 * */
	@Override
	public void insertBook(Book book) {
		
		getSqlMapClientTemplate().insert("book.insertBook", book);
		
	}

	/*
	 * 查询方法
	 * */
	@Override
	public List selectBookList() {
		
		return getSqlMapClientTemplate().queryForList("book.selectBookList");
		
	}

	@Override
	public void deleteBook(Integer bookId) {
		
		getSqlMapClientTemplate().delete("book.deleteBook",bookId);
	}

	@Override
	public Book queryByBookID(Integer bookId) {
		
		
		
		return  (Book) getSqlMapClientTemplate().queryForObject("book.queryByBookID",bookId);
		
	}

	@Override
	public void updateBook(Book book) {
		
		getSqlMapClientTemplate().update("book.updateBook", book);
	}

	@Override
	public List selectUserList(UserRequest userRequest) {
		
		return getSqlMapClientTemplate().queryForList("user.selectUserList",userRequest);
	}

	@Override
	public UserResponse Login(UserRequest userRequest) {
		
		return (UserResponse) getSqlMapClientTemplate().queryForObject("user.Login", userRequest);
	}

	@Override
	public void updateLoginFailDate(UserRequest userRequest) {
		
		getSqlMapClientTemplate().update("user.updateLoginFailDate", userRequest);
		
	}

	@Override
	public List queryTree() {
		List<Tree> queryForList = getSqlMapClientTemplate().queryForList("tree.queryTree");
			
		List list=new ArrayList();
		for (Tree tree : queryForList) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", tree.getId());
			map.put("pId", tree.getPid());
			map.put("name", tree.getName());
			list.add(map);
		}
		
		return list;
	}

	@Override
	public List selectUserRoleListJson(RoleRequest roleRequest) {
		
		
		return this.getSqlMapClientTemplate().queryForList("user.selectUserRoleListJson", roleRequest);
	}

	@Override
	public void deleteAllRolesByUserID(RoleRequest roleRequest) {
		
		
		this.getSqlMapClientTemplate().delete("user.deleteAllRolesByUserID", roleRequest);
	}

	@Override
	public void insertUserRoleList(final List<RoleRequest> roleRequestList) {
		
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {
			/* (non-Javadoc)    
			 * @see org.springframework.orm.ibatis.SqlMapClientCallback#doInSqlMapClient(com.ibatis.sqlmap.client.SqlMapExecutor)    
			 */
			@Override
			public Object doInSqlMapClient(SqlMapExecutor sqlMap) throws SQLException {
				//开启批量
				sqlMap.startBatch();
				//添加批量操作语句
				for (RoleRequest roleRequest : roleRequestList) {
					sqlMap.insert("user.insertUserRole", roleRequest);
				}
				//执行批量操作
				sqlMap.executeBatch();
				return null;
			}
		});
	}

	@Override
	public void insertUser(UserRequest userRequest) {
		
		getSqlMapClientTemplate().insert("user.insertUser", userRequest);
	}

	@Override
	public int selectUserCount(UserRequest userRequest) {
		
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject("user.selectUserCount", userRequest);
	}

	@Override
	public List<MenuResponse> selectUserMenuListJson(MenuRequest menuRequest) {
		
		return this.getSqlMapClientTemplate().queryForList("user.selectUserMenuListJson",menuRequest);
	}

	@Override
	public List selectBookByMD5(Book book) {
		
		return this.getSqlMapClientTemplate().queryForList("book.selectBookByMD5", book);
	}
}
