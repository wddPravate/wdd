/** 
 * <pre>项目名称:ssi-commen 
 * 文件名称:JsonUtil.java 
 * 包名:commen.util 
 * 创建日期:2017年7月31日下午2:50:53 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package commen.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/** 
 * <pre>项目名称：ssi-commen    
 * 类名称：JsonUtil    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月31日 下午2:50:53    
 * 修改人：王冬   
 * 修改时间：2017年7月31日 下午2:50:53    
 * 修改备注：       
 * @version </pre>    
 */
public class JsonUtil {

	private static Gson gson=new Gson();
	
	
	public static  String toJsonString(Object obj)
		{
			if(obj==null){
			throw new  NullPointerException();
			}
			String json = gson.toJson(obj);
			
		return json;
		} 
	
	
	public static <T> T fromJson(String json, Class<T> t) {
		if (null == json) {
			throw new NullPointerException();
		}
		T obj = gson.fromJson(json, new TypeToken<T>(){}.getType());
		return obj;
	}

		
}
