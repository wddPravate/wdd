package com.jk.dao.book;

import java.util.List;
import java.util.Map;

import com.jk.entity.book.Book;
import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;
import com.jk.entity.role.RoleRequest;
import com.jk.entity.user.UserRequest;
import com.jk.entity.user.UserResponse;

public interface BookDao {

	List selectAllBookInFo();

	void insertBook(Book book);

	List selectBookList();

	void deleteBook(Integer bookId);

	Book queryByBookID(Integer bookId);

	void updateBook(Book book);

	List selectUserList(UserRequest userRequest);

	UserResponse Login(UserRequest userRequest);

	void updateLoginFailDate(UserRequest userRequest);

	List queryTree();

	List selectUserRoleListJson(RoleRequest roleRequest);

	void deleteAllRolesByUserID(RoleRequest roleRequest);

	void insertUserRoleList(List<RoleRequest> roleRequestList);

	void insertUser(UserRequest userRequest);

	int selectUserCount(UserRequest userRequest);

	List<MenuResponse> selectUserMenuListJson(MenuRequest menuRequest);

	List selectBookByMD5(Book book);
	
	
	

}
