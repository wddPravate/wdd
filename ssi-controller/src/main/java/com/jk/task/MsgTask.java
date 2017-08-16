/** 
 * <pre>项目名称:ssi-controller 
 * 文件名称:MsgTask.java 
 * 包名:com.jk.task 
 * 创建日期:2017年8月1日上午9:57:01 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jk.entity.user.UserRequest;
import com.jk.entity.user.UserResponse;
import com.jk.service.book.BookService;

/** 
 * <pre>项目名称：ssi-controller    
 * 类名称：MsgTask    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年8月1日 上午9:57:01    
 * 修改人：王冬   
 * 修改时间：2017年8月1日 上午9:57:01    
 * 修改备注：       
 * @version </pre>    
 */

@Component
public class MsgTask {
	
	@Resource
	private BookService bookService;
	
	
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Scheduled(cron ="0 10 11 * * ?")
	public void  demoTask()
	{
		System.out.println("这是一个指定计时器的Demo"+sim.format(new Date()));
	}
	
	
	@Scheduled(fixedRate = 3000,initialDelay=5000)
	public void sendMsg(){
		UserRequest userRequest=new UserRequest();
		int selectUserCount=bookService.selectUserCount(userRequest);
		userRequest.setTotalCount(selectUserCount);
		userRequest.calculate();
		List<UserResponse> selectUserList = bookService.selectUserList(userRequest);
		for (UserResponse userResponse : selectUserList) {
			System.out.println(userResponse.getUserName());
		}
		
		System.out.println("这是一个频度计时器"+sim.format(new Date()));
	}

}
