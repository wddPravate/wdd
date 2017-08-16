/** 
 * <pre>项目名称:ssi-commen 
 * 文件名称:RequestListener.java 
 * 包名:commen.listener 
 * 创建日期:2017年7月23日下午1:35:52 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package commen.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextListener;

/** 
 * <pre>项目名称：ssi-commen    
 * 类名称：RequestListener    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月23日 下午1:35:52    
 * 修改人：王冬   
 * 修改时间：2017年7月23日 下午1:35:52    
 * 修改备注：       
 * @version </pre>    
 */
public class RequestListener extends RequestContextListener{
	
	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) requestEvent.getServletRequest();
		super.requestInitialized(requestEvent);
		
		System.out.println("用户进行了一次请求"+request.getRequestURI());
	}
	

}
