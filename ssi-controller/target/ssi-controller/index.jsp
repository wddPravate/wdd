<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/jquery/jquery-1.10.2.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/uploadify/uploadify.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/uploadify/jquery.uploadify.min.js"></script>
<title>Insert title here</title>
</head>
<body>	

<form action="insertBook.jhtml" method="post" enctype="multipart/form-data">

<table>
	<tr>
		<td>书籍名称</td>
		<td><input name="bookName" ></td>
	</tr>
	<tr>
		<td>书籍价格</td>
		<td><input name="bookPrice"></td>
	</tr>
	
	<tr>
		<td>书籍封面：</td>
		<td>
			
				<img id="myUploadImg"/>
				<input type="file" id="upLoadImg" name="file"/>
				<input type="hidden" id="myUploadImg2" name="bookImg"  value="${book.bookImg }"/>
				<input type="hidden" id="loadPhotos" name="bookMD5"  value="${book.bookMD5 }"/>
		</td>
	</tr>
</table>





<input type="submit" value="保存">
</form>
<input type="button" value="查询列表" onclick="toShow();">
<script type="text/javascript">

$(function(){
	upLoad();
})
	function toShow(){
	location="selectBookList.jhtml";	
	}
	
	/*
	上传图片
	*/
	function upLoad(){
	
		$("#upLoadImg").uploadify({
			'swf':'uploadify/uploadify.swf',//swf uploadify的控制展示属性 flash基础文件 上传的进度条 和上传按钮功能
			'uploader':'uploadImg.jhtml',//声明文件的上传地址 上传到对应的action请求
			'buttonText':'上传封面',
			'mulit':false,
			'fileTypeDesc':'只能上传图片',
			'fileTypeExts':'*.jpg;*.png',
			'fileObjName':'file',
			'onUploadSuccess':function(response,data){//第二个参数为后台返回的数据
				data = eval("("+data+")");
				//alert(data)
				//alert(response)
			   	//替换图片原有路径 达到上传图片预览的目的
			   	alert(data.url)
				  $("#loadPhotos").val(data.md5); 
			    $("#myUploadImg").attr("src","ftp://root:root@192.168.1.156:21/"+data.url);
			   $("#myUploadImg2").val(data.url); 
				
			}
		})
	}
</script>
</body>
</html>