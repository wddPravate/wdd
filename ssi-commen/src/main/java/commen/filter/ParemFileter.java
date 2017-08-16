/** 
 * <pre>项目名称:ssi-commen 
 * 文件名称:ParemFileter.java 
 * 包名:commen.filter 
 * 创建日期:2017年7月23日下午2:22:46 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package commen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/** 
 * <pre>项目名称：ssi-commen    
 * 类名称：ParemFileter    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月23日 下午2:22:46    
 * 修改人：王冬   
 * 修改时间：2017年7月23日 下午2:22:46    
 * 修改备注：       
 * @version </pre>    
 */
public class ParemFileter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("欢迎来到王者荣耀");
		HttpServletRequest httpServlet= (HttpServletRequest) request;
	
		System.out.println(httpServlet.getSession().getId()); 
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
