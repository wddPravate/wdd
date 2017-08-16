<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 代码开始 -->
	<form id="login_form">
		
		<input type="button" value="登陆" onclick="user_test()">
	</form>
	
	<!-- 代码结束 -->
	
	<script type="text/javascript">
		
		//ajax登陆
		function user_test() {
			$.ajax({
				url:"<%=request.getContextPath() %>/selectUserList.jhtml",
				type:"post",
				dataType:"json",
				success:function(data) {
					console.log(data);
					
				}
			});
		}
	
		$.ajaxSetup( {
			//设置ajax请求结束后的执行动作
			complete : 
			function(XMLHttpRequest, textStatus) {
			// 通过XMLHttpRequest取得响应头，sessionstatus
			var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus");
			if (sessionstatus == "TIMEOUT") {
			var win = window;
			while (win != win.top){
			win = win.top;
			}
			win.location.href= XMLHttpRequest.getResponseHeader("CONTEXTPATH");
			}
			}
			});
	
	</script>
</body>
</html>