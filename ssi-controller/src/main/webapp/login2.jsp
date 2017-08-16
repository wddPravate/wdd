<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>Fullscreen Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>
	<script src="js/canvas-nest.js" count="200" zindex="-2" opacity="0.5" color="47,135,193" type="text/javascript"></script>
        <div class="page-container">
            <h1>Login</h1>
            <form id="login_form">
              	<input type="text" name="userName" class="username" placeholder="请输入用户名">
               	<input type="password" name="userPwd" class="password" placeholder="请输入密码">
            	<input type="text" name="userCodeImg" class="password" placeholder="验证码">
		          	<br>    
		          <div onclick="change_imgcode()">
				
				
					<img id="imgcode_src_node" src="<%=request.getContextPath() %>/imgcode">
					<font color="red">看不清，点击换一张</font>
				
				</div> 
                <button type="button" value="登陆" onclick="user_login()">点击登陆</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>
        <div align="center">Collect from <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a></div>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

<script type="text/javascript">
		
		//ajax登陆
		function user_login() {
			$.ajax({
				url:"<%=request.getContextPath() %>/Login.jhtml",
				data:$("#login_form").serialize(),
				type:"post",
				dataType:"json",
				success:function(data) {
					console.log(data);
					if (1 == data.flag) {
						//成功
						location.href = "bootstrapPage.jsp";
						return;
					}
					if (2 == data.flag) {
						alert("用户不存在");
						return;
					}
					if (3 == data.flag) {
						alert("密码错误"+data.loginfailnum);
						return;
					}
					if (4 == data.flag) {
						alert("验证码错误");
						return;
					}
					if (5 == data.flag) {
						alert("验证码为空");
						return;
					}
					if (6 == data.flag) {
						alert("用户被锁定");
						return;
					}
				}
			});
		}
	
		//切换验证码
		function change_imgcode() {
			$("#imgcode_src_node").attr("src", "<%=request.getContextPath() %>/imgcode?time=" + new Date().getTime());
		}
	
	</script>
    </body>

</html>

