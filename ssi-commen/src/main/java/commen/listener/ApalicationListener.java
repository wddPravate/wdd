/** 
 * <pre>项目名称:ssi-commen 
 * 文件名称:ApalicationListener.java 
 * 包名:commen.listener 
 * 创建日期:2017年7月23日下午2:04:02 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package commen.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 
 * <pre>项目名称：ssi-commen    
 * 类名称：ApalicationListener    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月23日 下午2:04:02    
 * 修改人：王冬   
 * 修改时间：2017年7月23日 下午2:04:02    
 * 修改备注：       
 * @version </pre>    
 */
public class ApalicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("我已经吧过滤器和监听练会了，我不用被打断腿");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
