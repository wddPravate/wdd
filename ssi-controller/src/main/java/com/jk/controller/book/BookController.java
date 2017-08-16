package com.jk.controller.book;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.jk.entity.book.Book;
import com.jk.entity.menu.MenuRequest;
import com.jk.entity.menu.MenuResponse;
import com.jk.entity.role.RoleRequest;
import com.jk.entity.user.UserRequest;
import com.jk.entity.user.UserResponse;
import com.jk.service.book.BookService;

import commen.base.MySessionContest;
import commen.util.DateUtil;
import commen.util.FTPUtil;
import commen.util.FileUtil;
import commen.util.JedisUtil;
import commen.util.JsonUtil;


@Controller
public class BookController {
	
	@Resource
	private BookService bookService;
	


	@RequestMapping("uploadImg")
	public void uploadImg(Book book,@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request,HttpServletResponse response){
		/*String realPath = request.getSession().getServletContext().getRealPath("upImg");
        System.out.println(realPath);
        File fileCheck = new File(realPath);
		if(!fileCheck.exists()){ //判断文件是否存在
			fileCheck.mkdir(); //根据文件的路径  创建文件夹
		}


		//重命名文件名  保证文件的唯一性
		String imgUrl = "\\"+UUID.randomUUID().toString()+file.getOriginalFilename();
		
		String url = "upImg"+imgUrl;
		
        String path=realPath+imgUrl;
        System.out.println(path);
        File newFile=new File(path);
        PrintWriter writer = null;
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        try {
			file.transferTo(newFile);
			writer = response.getWriter();
			writer.println(url);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer != null){
				writer.close();
			}
		}*/
        
		
		 try {
				InputStream inputStream=file.getInputStream();
				
				String md5 = FileUtil.getMD5(inputStream, "md5");
				//从数据库判断这个指纹存在
				book.setBookMD5(md5);
			List<Book> userList=	bookService.selectBookByMD5(book);
				
				//如果存在，直接把地址返回给用户
			if(userList.size()>0){
				
				Map<String ,Object> map=new HashMap<String ,Object>();
				map.put("url", userList.get(0).bookImg);
				String  json = new Gson().toJson(map);
				  response.setCharacterEncoding("utf-8");
				    try {
						PrintWriter writer = response.getWriter();
						
						writer.write(json);
						writer.flush();
						writer.close();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
				 
			}else{

				//如果不存在，保存这个文件到ftp服务器，并且把保存的指纹和路径存到数据库
				
				//文件名
				String originalFilename = file.getOriginalFilename();
				
				String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
				
			String	fileName=UUID.randomUUID().toString()+suffix;
			
			String path="wdd/"+DateUtil.formatDateToString(new Date(),"yyyy/MM/dd" );
			
			String url=path+"/"+fileName;
			
			Map<String ,Object> map=new HashMap<String ,Object>();
			map.put("url", url);
			map.put("md5", md5);
			map.put("fileName", fileName);
			
			String  json = new Gson().toJson(map);
			  response.setCharacterEncoding("utf-8");
			    try {
					PrintWriter writer = response.getWriter();
					
					writer.write(json);
					writer.flush();
					writer.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			boolean boo = FTPUtil.uploadFile(file.getInputStream(), fileName, path);
			
			
			if(boo){
				
				System.out.println("文件保存在》》"+path+"/"+fileName);
			}
				
			}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	@RequestMapping("insertUser")
	@ResponseBody
	String insertUser(UserRequest userRequest) {
		
		bookService.insertUser(userRequest);
		//重定向
		return "{}";
	}
	
	@RequestMapping("toAddUserPage")
	public String toAddUserPage(){
		
		
		return"user/addUser";
	}
	
	@RequestMapping("insertUserRoleList")
	@ResponseBody
	String insertUserRoleList(@RequestBody List<RoleRequest> roleRequestList) {
		bookService.insertUserRoleList(roleRequestList);
		return "{}";
	}
	
	
	@RequestMapping({"selectUserRoleListJson"})
	@ResponseBody
	public void selectUserRoleListJson(HttpServletResponse response,RoleRequest roleRequest){
		
		
		List list=bookService.selectUserRoleListJson(roleRequest);
		 String  json = new Gson().toJson(list);
		    response.setCharacterEncoding("utf-8");
		    try {
				PrintWriter writer = response.getWriter();
				
				writer.write(json);
				writer.flush();
				writer.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	
	@RequestMapping({"queryTree"})
	@ResponseBody
	public void queryTree(HttpServletResponse response){
		
		
		List list=bookService.queryTree();
		 String  json = new Gson().toJson(list);
		    response.setCharacterEncoding("utf-8");
		    try {
				PrintWriter writer = response.getWriter();
				
				writer.write(json);
				writer.flush();
				writer.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	@RequestMapping({"toBootStrap"})
	public String toBootStrap(){
		
		return "user/userList";
	}
	
	@RequestMapping({"toUserRolePage"})
	public String toUserRolePage(ModelMap map,UserRequest userRequest){
		map.addAttribute("t_userId", userRequest.getUserID());
		
		return "user/user_role";
	}

	@RequestMapping({"logout"})
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		
		return"redirect:login2.jsp";
	}
	
	@RequestMapping({"Login"})
	
	public @ResponseBody Map<String,Object> Login(UserRequest userRequest,HttpServletRequest request){
		HttpSession session = request.getSession();
		Object codeObj = session.getAttribute("imageCode");
		if(codeObj==null){
			codeObj="";
		}
		String code = codeObj.toString();
		userRequest.setSysCodeImg(code);
		
		Map<String,Object> map=	bookService.Login(userRequest);
		Object userInfo = (UserResponse)map.get("userInfo");
		if(userInfo!=null)
		{	 UserResponse userResponse= (UserResponse) userInfo;
			//登陆成功后将信息存入session
			session.setAttribute("userInfo", map.get("userInfo"));
			//设置session过期时间
			session.setMaxInactiveInterval(600);
			
			
		String userId=	userResponse.getUserID()+"";
		//移除session
		MySessionContest.removeSession(userId,session);
		//添加session
		MySessionContest.addSession(userId, session);
		MenuRequest menuRequest = new MenuRequest();
		menuRequest.setUserID(userResponse.getUserID());
		
		List<MenuResponse> treeList = bookService.selectMenuListJson(menuRequest);
		//放到jedis当中
		JedisUtil.setString(userId + "#tree_list", JsonUtil.toJsonString(treeList), -1);
		
		}
		return map;
	}
	
	
	/* @RequestMapping({"selectUserList"})
	  public ModelAndView selectBookList(UserRequest userRequest) {
		 
	    List boList = this.bookService.selectUserList(userRequest);
	    
	    ModelAndView mv = new ModelAndView();
	    
	    mv.addObject("list", boList);
	    
	    mv.setViewName("user/userList");
	    
	    return mv;
	 }*/
	 
	 @RequestMapping({"selectUserList"})
	  public void selectUserList(String pageNumber,UserRequest userRequest,HttpServletResponse response) {
		 
		 int totalCount=bookService.selectUserCount(userRequest);
		 
		 userRequest.setTotalCount(totalCount);
		 if (null == pageNumber || "".equals(pageNumber.trim())) {
			 pageNumber = "1";
		 }
		 userRequest.setPageIndex(Integer.valueOf(pageNumber));
		 
		 userRequest.calculate();
	    List boList = this.bookService.selectUserList(userRequest);
	    
	    Map<String, Object> map=new HashMap<String, Object>();
	    map.put("total", totalCount);
	    map.put("rows", boList);
	    String  json = new Gson().toJson(map);
	    response.setCharacterEncoding("utf-8");
	    try {
			PrintWriter writer = response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	 
	    
	  }
	 
	@RequestMapping({"test"})
	public void test(){
		
		System.out.println(123+"===========");
	}
	
	@RequestMapping({"toshow"})
	public ModelAndView test2(){
		
		 ModelAndView mv = new ModelAndView();
		 
		    mv.setViewName("book/list");
		    
		    return mv;
	}
	
	@RequestMapping({"show"})
	public void selectAllBookInFo(){
		
		List list = bookService.selectAllBookInFo();
		
	}
	
	@RequestMapping({"insertBook"})
	  public String insertBook(Book book) {
		
	    this.bookService.insertBook(book);
	    
	    return "redirect:selectBookLists.jhtml";
	    
	  }
	
	@RequestMapping({"deleteBook"})
	  public String deleteBook(Book book) {
		
	    this.bookService.deleteBook(book.getBookId());
	    
	    return "redirect:selectBookList.jhtml";
	  }
	
	 @RequestMapping({"selectBookLists"})
	  public ModelAndView selectBookList(Book book) {
		 
	    List boList = this.bookService.selectBookList();
	    
	    ModelAndView mv = new ModelAndView();
	    
	    mv.addObject("list", boList);
	    
	    mv.setViewName("book/list");
	    
	    return mv;
	    
	  }
	 
	 @RequestMapping({"selectBookList"})
	  public void selectBookList(Book book,HttpServletResponse response) {
		 
	    List boList = this.bookService.selectBookList();
	    
	    String  json = new Gson().toJson(boList);
	    response.setCharacterEncoding("utf-8");
	    try {
			PrintWriter writer = response.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	 
	    
	  }
	 @RequestMapping({"queryByBookID"})
	  public ModelAndView queryByBookID(Book book) {
		 
	    book = this.bookService.queryByBookID(book.getBookId());
	    
	    ModelAndView mv = new ModelAndView();
	    
	    mv.addObject("book", book);
	    
	    mv.setViewName("book/updateBook");
	    
	    return mv;
	    
	  }
	 
	 
	 @RequestMapping({"updateBook"})
	  public String updateBook(Book book) {
		 
	    this.bookService.updateBook(book);
	    
	    return "redirect:selectBookList.jhtml";
	    
	  }
	 
	 @RequestMapping("userPhotoUpload")
	 public void userPhotoUpload(MultipartFile userPhoto){
		 
		 try {
			InputStream inputStream=userPhoto.getInputStream();
			
			String md5 = FileUtil.getMD5(inputStream, "md5");
			//从数据库判断这个指纹存在
			System.out.println("文件指纹"+md5);
			
			//如果存在，直接把地址返回给用户
			
			//如果不存在，保存这个文件到ftp服务器，并且把保存的指纹和路径存到数据库
			
			//文件名
			String originalFilename = userPhoto.getOriginalFilename();
			
			String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
			
		String	fileName=UUID.randomUUID().toString()+suffix;
		
		String path="wdd/"+DateUtil.formatDateToString(new Date(),"yyyy/MM/dd" );
		
		boolean boo = FTPUtil.uploadFile(userPhoto.getInputStream(), fileName, path);
		
		if(boo){
			
			System.out.println("文件保存在》》"+path+"/"+fileName);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
}
