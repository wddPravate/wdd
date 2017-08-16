/** 
 * <pre>项目名称:ssi-controller 
 * 文件名称:TestFTP.java 
 * 包名:com.jk.ftp 
 * 创建日期:2017年8月1日下午7:13:55 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.ftp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

/** 
 * <pre>项目名称：ssi-controller    
 * 类名称：TestFTP    
 * 类描述：    
 * 创建人：王冬
 * 创建时间：2017年8月1日 下午7:13:55    
 * 修改人：王冬   
 * 修改时间：2017年8月1日 下午7:13:55    
 * 修改备注：       
 * @version </pre>    
 */
public class TestFTP {
	
	@Test
	public void connFTP(){
		
		/*
		 *1，实例化客户端
		 * */
		FTPClient ftp=new FTPClient();
		
		
		
	try {
		//2、链接服务器
		ftp.connect("192.168.1.100", 21);
		
		//3、登陆服务器,账号密码正确返回true ，错误返回FALSE
		boolean login = ftp.login("root", "root");
		
		if(login){
			//4.切换到根目录下
			ftp.changeWorkingDirectory("/");
			
			//4.1 切换到 xxx目录下
			boolean ss = ftp.changeWorkingDirectory("wdd");
			
			if(!ss){
				
				ftp.makeDirectory("wdd");
				
			}
			//上传媒体文件时需要转换为二进制对象
			
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			
		InputStream f=new FileInputStream("D:/ssss/35d3354ffa5a2a30b3de05a1.jpg");
		
			boolean storeFile = ftp.storeFile(new String("35d3354ffa5a2a30b3de05a1.jpg".getBytes("GBK"), "ISO-8859-1"), f);
			System.out.println(storeFile);
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
}
