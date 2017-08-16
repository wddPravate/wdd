/** 
 * <pre>项目名称:ssi-commen 
 * 文件名称:PermissionInterceptor.java 
 * 包名:commen.interceptor 
 * 创建日期:2017年7月31日上午10:50:45 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package commen.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import commen.util.JedisUtil;
import commen.util.JsonUtil;


/** 
 * <pre>项目名称：ssi-commen    
 * 类名称：PermissionInterceptor    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月31日 上午10:50:45    
 * 修改人：王冬   
 * 修改时间：2017年7月31日 上午10:50:45    
 * 修改备注：       
 * @version </pre>    
 */
public class PermissionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object object = session.getAttribute("userInfo");
		String json = new Gson().toJson(object);
		int userID = new JsonParser().parse(json).getAsJsonObject().get("userID").getAsInt();
		/*
		 * 获取用户访问的url与权限中的URL作对比，如果匹配就向后执行，如果不匹配就返回无权限页面
		 * */
		String uri = request.getRequestURI();
		
		//取出redis当中的菜单列表
		String string = JedisUtil.getString(userID+"#tree_list");
		
		int flag = 0;
		//List<Map<String, Object>>
		List<Map<String, Object>> treeList = JsonUtil.fromJson(string, new ArrayList<Map<String, Object>>(){}.getClass());
		for (Map<String, Object> map : treeList) {
			Object href = map.get("url");
			if (null == href) {
				continue;
			} else if (uri.contains(href.toString())) {
				flag = 1;
				break;
			}
		}
		
		if (1 == flag) {
			return true;
		} else {
			return false;
		}
		
	
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
