/** 
 * <pre>项目名称:maven-web-test3 
 * 文件名称:MySessionContest.java 
 * 包名:commen.base 
 * 创建日期:2017年7月21日下午7:19:25 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */
package commen.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * <pre>
 * 项目名称：maven-web-test3    
 * 类名称：MySessionContest    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月21日 下午7:19:25    
 * 修改人：王冬   
 * 修改时间：2017年7月21日 下午7:19:25    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
public class MySessionContest {

	private static Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();

	public static Map addSession(String userId, HttpSession session) {

		sessionMap.put(userId, session);
		return sessionMap;
	}

	public static void removeSession(String userId,HttpSession session) {
		HttpSession httpSession = sessionMap.get(userId);
		if (null != httpSession) {
			// 使原来存在的session失效
			// 判断session是否失效，没有失效的让他失效
			String json = new Gson().toJson(httpSession);
			boolean valid = new JsonParser().parse(json).getAsJsonObject().get("session")
					.getAsJsonObject().get("isValid").getAsBoolean();
			if (valid && !httpSession.getId().equals(session.getId())) {
				httpSession.invalidate();
			}
		}

	}
	
	public static HttpSession getSession(String userID) {
		return sessionMap.get(userID);
	}

}
