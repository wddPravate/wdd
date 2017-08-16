<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<input type="button" value="退出登录" onclick="location.href='<%=request.getContextPath() %>/logout.jhtml'" >
<table border="1px" cellpadding="5" cellspacing="0">
	<tr>
		<td>主键</td>
		<td>书籍名称</td>
		<td>书籍价格</td>
		<td>书籍封面 </td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list }" var="book">
		<tr>
			<td>${book.bookId}</td>
			<td>${book.bookName}</td>
			<td>${book.bookPrice}</td>
			<td><img alt="没有封面" src="ftp://root:root@192.168.1.156:21/${book.bookImg}" width="150px"></td>
			<td>
				
		<input type="button" value="删除" onclick="deleteBook('${book.bookId}');">
				
 		<input type="button" value="修改" onclick="queryByBookID('${book.bookId}');">
			</td>
			
		</tr>
	</c:forEach>
</table>
</center>
<script type="text/javascript">
	function deleteBook(id){
		location="<%=request.getContextPath()%>/deleteBook.jhtml?bookId="+id;
		
	}
	
	function queryByBookID(id){
		location="<%=request.getContextPath()%>/queryByBookID.jhtml?bookId="+id;
		
	}
</script>
</body>
</html>