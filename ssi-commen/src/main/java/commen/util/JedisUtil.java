/** 
 * <pre>项目名称:ssi-commen 
 * 文件名称:JedisUtil.java 
 * 包名:commen.util 
 * 创建日期:2017年7月31日下午2:59:08 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package commen.util;


import redis.clients.jedis.Jedis;

/** 
 * <pre>项目名称：ssi-commen    
 * 类名称：JedisUtil    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年7月31日 下午2:59:08    
 * 修改人：王冬   
 * 修改时间：2017年7月31日 下午2:59:08    
 * 修改备注：       
 * @version </pre>    
 */
public class JedisUtil {
	
	private static Jedis jedis=null;
	
	private static Jedis getJedis() {
		if (null == jedis) {
			synchronized (JedisUtil.class) {
				if (null == jedis) {
					jedis = new Jedis("192.168.20.128", 6379);
					jedis.auth("admin");
				}
			}
		}
		return jedis;
	}
	
	
	public static String setString (String k, String v, int seconds){
		
		Jedis jedis=getJedis();
		
		String s=jedis.set(k, v);
		if(0<=seconds)
		{
			jedis.expire(k, seconds);
		}
		
		
		return s;
	}
	
	
	public static  String getString (String k){
	Jedis	jedis=getJedis();
	String v=jedis.get(k);
		
		return v;
	}

}
