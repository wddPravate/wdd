package com.jk.service.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.book.BookDao;
import com.jk.entity.book.Book;
import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;
import com.jk.entity.role.RoleRequest;
import com.jk.entity.user.UserRequest;
import com.jk.entity.user.UserResponse;

import commen.constant.Constant;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;
	
	public List selectAllBookInFo() {
		
		return bookDao.selectAllBookInFo();
		
	}

	@Override
	public void insertBook(Book book) {
		
		this.bookDao.insertBook(book);
		
	}

	@Override
	public List selectBookList() {

		return this.bookDao.selectBookList();
		
	}

	@Override
	public void deleteBook(Integer bookId) {
		
		this.bookDao.deleteBook(bookId);
	}

	@Override
	public Book queryByBookID(Integer bookId) {
		
		return this.bookDao.queryByBookID(bookId);
	}

	@Override
	public void updateBook(Book book) {
		
		this.bookDao.updateBook(book);
	}

	@Override
	public List selectUserList(UserRequest userRequest) {
		
		return bookDao.selectUserList(userRequest);
	}

	@Override
	public Map<String, Object> Login(UserRequest userRequest) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", Constant.LOGIN_USERPWD_ERROR);
		map.put("userInfo", null);
		if(userRequest.getUserCodeImg()==null){
			map.put("flag", Constant.LOGIN_CODE_NULL);
			
		}else if(userRequest.getUserCodeImg().equals(userRequest.getSysCodeImg()))
		
		{
			UserResponse userResponse=bookDao.Login(userRequest);
			//判断用户是否存在      
			if(userResponse==null)
			{
				
				map.put("flag", Constant.LOGIN_USERNAME_ERROR);
				//判断用户是否被锁定，
			}else 
				if( 0 == userResponse.getLoginFailNum() 
						|| userResponse.getLoginFailNum() % 3 >0 
						|| userResponse.getLoginFailDate() > 300000)
				{
					//当用户没有被锁定事比较密码是否正确，密码正确登录成功后将错误次数修改为0
					if(userResponse.getUserPwd().equals(userRequest.getUserPwd()))
					{
						map.put("flag", Constant.LOGIN_SUCCESS);
						map.put("userInfo", userResponse );
						userRequest.setLoginFailNum(0);
						
					}
					//当用户密码错误时判断距离上一次错误时间是否超过5分钟，如果超过5分钟则将错误次数改为1
					else if(userResponse.getLoginFailDate() > 300000){
						userRequest.setLoginFailNum(1);
						map.put("loginfailnum", 1);
					}
					//如果距离上一次错误时间不超过5分钟则错误次数加一
					else{
						userRequest.setLoginFailNum(userResponse.getLoginFailNum()+1);
						map.put("loginfailnum", userResponse.getLoginFailNum()+1);
					}
				
				
				bookDao.updateLoginFailDate(userRequest);
		}else{
			map.put("flag", Constant.LOGIN_FAIL_NUM);
		}
		}else{
			map.put("flag", Constant.LOGIN_CODE_ERROR);
			
		}
		
		return map;
	}

	@Override
	public List queryTree() {
		
		return bookDao.queryTree();
	}

	@Override
	public List selectUserRoleListJson(RoleRequest roleRequest) {
		// TODO Auto-generated method stub
		return bookDao.selectUserRoleListJson(roleRequest);
	}

	@Override
	public void insertUserRoleList(List<RoleRequest> roleRequestList) {
		
		// 1、删除用户之前的所有角色（mid）
		bookDao.deleteAllRolesByUserID(roleRequestList.get(0));
				// 2、添加用户勾选的所有角色（mid）
		bookDao.insertUserRoleList(roleRequestList);
			}

	@Override
	public void insertUser(UserRequest userRequest) {
		
		bookDao.insertUser(userRequest);
	}

	@Override
	public int selectUserCount(UserRequest userRequest) {
		
		return bookDao.selectUserCount(userRequest);
	}

	@Override
	public List<MenuResponse> selectMenuListJson(MenuRequest menuRequest) {
		
		return bookDao.selectUserMenuListJson(menuRequest);
	}

	@Override
	public List selectBookByMD5(Book book) {
		
		return bookDao.selectBookByMD5(book);
		
	}
		
	}

