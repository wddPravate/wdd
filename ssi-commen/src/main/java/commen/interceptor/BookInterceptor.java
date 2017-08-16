/** 
 * <pre>项目名称:maven-web-test3 
 * 文件名称:BookInterceptor.java 
 * 包名:commen.interceptor 
 * 创建日期:2017年7月19日下午2:07:32 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package commen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * <pre>项目名称：maven-web-test3    
 * 类名称：BookInterceptor    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月19日 下午2:07:32    
 * 修改人：王冬   
 * 修改时间：2017年7月19日 下午2:07:32    
 * 修改备注：       
 * @version </pre>    
 */
public class BookInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		String id = session.getId();
		
		System.out.println(id);
		
		String requestURI = request.getRequestURI();
		
		System.out.println(requestURI);
		
		String queryString = request.getQueryString();
		
		System.out.println(queryString);
		
		String remoteHost = request.getRemoteHost();
		
		System.out.println(remoteHost);
		
/*		return super.preHandle(request, response, handler);
	return true;*/	
		
		if(session.getAttribute("userInfo")!=null){
			
			
			
			return true;
		}else{
			String type = request.getHeader("X-Requested-With");// XMLHttpRequest
			// 重定向
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
			//response.sendRedirect(contextPath+"/index.jsp");
			// System.err.println("sendRedirect");
			// 转发
			if (StringUtils.equals("XMLHttpRequest", type)) {
			// ajax请求
			response.setHeader("SESSIONSTATUS", "TIMEOUT");
			response.setHeader("CONTEXTPATH", basePath+"login2.jsp");

			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return false;
			}else{
				response.sendRedirect(request.getContextPath()+"/login2.jsp");
			}
			
			
		}
		return false;
		
		
		
		
	}

}
