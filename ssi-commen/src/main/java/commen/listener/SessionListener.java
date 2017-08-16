/** 
 * <pre>项目名称:ssi-commen 
 * 文件名称:SessionListener.java 
 * 包名:commen.listener 
 * 创建日期:2017年7月23日下午1:54:32 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package commen.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/** 
 * <pre>项目名称：ssi-commen    
 * 类名称：SessionListener    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月23日 下午1:54:32    
 * 修改人：王冬   
 * 修改时间：2017年7月23日 下午1:54:32    
 * 修改备注：       
 * @version </pre>    
 */
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		String id = se.getSession().getId();
		System.out.println("用户进行了一次session回话"+id);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

}
