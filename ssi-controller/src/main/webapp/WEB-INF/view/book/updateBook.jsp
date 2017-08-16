<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
${book }
<form action="updateBook.jhtml" method="post">


<input type="hidden" name="bookId" value="${book.bookId}" >
书籍名称<input name="bookName" value="${book.bookName}"><br>

书籍价格<input name="bookPrice" value="${book.bookPrice}">
<input type="submit" value="保存">
</form>
</body>
</html>