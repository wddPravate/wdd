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


	<!-- 搜索面板 -->
    <div class="tab-content" style="padding: 4px">
	    <form id="search_user_form">
	    	<label>用户账号：</label>
			<input id="query_user_name" class="form-control-sm" placeholder="请输入用户账号">
			<div align="center">
				<!-- Single button -->
				<div class="btn-group">
				  <button type="button" class="btn btn-success glyphicon glyphicon-search" onclick="search_user()">搜索</button>
				</div>
				<div class="btn-group">
				  <button type="button" class="btn btn-danger glyphicon glyphicon-repeat" onclick="reset_search_user_form()">重置</button>
				</div>
			</div>
		</form>
    </div>


<div id="user_tb">
		<!-- Single button -->
		<div class="btn-group">
		  <button type="button" class="btn btn-success" onclick="show_add_dialog()">新增</button>
		</div>
		<div class="btn-group">
		  <button type="button" class="btn btn-danger" onclick="delete_all_checked_book()">删除</button>
		</div>
	</div>

</center>

<table id="user_dg"></table>


<script type="text/javascript">
		//初始化数据表格
		$('#user_dg').bootstrapTable({
			url:"<%=request.getContextPath() %>/selectUserList.jhtml",
			dataType:"json",
			//请求方式
			method:"post",
			//必须的，操你大爷！！！！不然会造成中文乱码
			contentType: "application/x-www-form-urlencoded",
			//斑马线
			striped:true,
			//设置分页
			 pagination:true,
			paginationLoop:true,
			pageNumber:1,
			pageSize:5,
			pageList:[3,5,8,10], 
			//工具条
			 toolbar:"#user_tb", 
			//设置后台分页
			 sidePagination:"server",
			//开启搜索框
			search:true, 
			//显示刷新按钮
			showRefresh:true,
			queryParams:function(params) {
				params.userName = $("#query_user_name").val();
				console.log(params);
				return params;
			},
			queryParamsType:"",
		    columns: [{
		        checkbox:true
		    }, {
		        field: 'userID',
		        title: '主键'
		    }, {
		        field: 'userName',
		        title: '用户名称'
		    }, {
		        field: 'userPwd',
		        title: '用户密码'
		    }, 
		    {
		        field: 'cz',
		        title: '操作',
		        formatter:function(value, row, index) {
		        	var zc_btn_group = '<div class="btn-group">'
		        	+ '<button type="button" class="btn btn-xs btn-success" onclick="show_edit_dialog(\'' + row.bookID + '\')">编辑</button>'
		        	+ '</div>&nbsp;&nbsp;'
		        	+ '<div class="btn-group">'
		        	+ '<button type="button" class="btn btn-xs btn-danger" onclick="delete_checked_book(\'' + row.bookID + '\')">删除</button>'
		        	+ '</div>&nbsp;&nbsp;'
		        	+ '<div class="btn-group">'
		        	+ '<button type="button" class="btn btn-xs btn-danger" onclick="edit_user_role(\'' + row.userID + '\')">角色操作</button>'
		        	+ '</div>&nbsp;&nbsp;';
		        	return zc_btn_group;
		        }
		    },
		    <%-- {
		        field: 'bookType',
		        title: '书籍类型'
		    }, {
		        field: 'date',
		        title: '出版日期',
		        //width:92,
		        formatter:formatDatebox
		    }, {
		        field: 'bookAuthor',
		        title: '书籍封面',
		        formatter:function(value, row, index) {
		        	var zc_btn_group = '<img src="<%=request.getContextPath() %>/images/def/01.JPG" width="60" height="28"/>';
		        	if (null != row.attachID && "" != row.attachID) {
		        		zc_btn_group = '<img src="<%=request.getContextPath() %>/book/loadMainImg.action?book.attachID=' + row.attachID + '" width="60" height="28"/>';
		        	}
		        	return zc_btn_group;
		        }
		    },--%>  ]
		});
	
		function edit_user_role(t_userId){
			BootstrapDialog.show({
				title:"用户管理>>用户赋角色",
				message: $('<div></div>').load('<%=request.getContextPath() %>/toUserRolePage.jhtml?userID=' + t_userId),
				buttons: [{
	                label: '确定',
	                cssClass:"btn btn-success",
	                action: function(dialogItself){
	                	var role_json_array = get_selection_tree_nodes();
	                	//使用ajax保存结果
	                	$.ajax({
	                	    url:"<%=request.getContextPath() %>/insertUserRoleList.jhtml",
	                		data:JSON.stringify(role_json_array),
	                		dataType:"json",
	                		type:"post",
	                		success:function(data) {
	                			alert(1)
	                			//关闭对话框
	                			dialogItself.close();
	                		},
	                		contentType:"application/json"
	               	}); 	
	                }
	            }, {
	                label: '取消',
	                cssClass:"btn btn-danger",
	                action: function(dialogItself){
	                	dialogItself.close();
	                }
	            }],
				
			});
			
		}
		
		
		//新增用户
		function show_add_dialog() {
			BootstrapDialog.show({
				title:"新增用户",
				message:$('<div></div>').load('<%=request.getContextPath() %>/toAddUserPage.jhtml'),
				buttons: [{
	                label: '确定',
	                cssClass:"btn btn-success",
	                action: function(dialogItself){
	                	//使用ajax保存结果
	                	$.ajax({
	                		url:"<%=request.getContextPath() %>/insertUser.jhtml",
	                		data:$("#add_user_form").serialize(),
	                		dataType:"json",
	                		type:"post",
	                		success:function(data) {
	                			//刷新表格
	                			$('#user_dg').bootstrapTable("refresh");
	                			//关闭对话框
	                			dialogItself.close();
	                		},
	                	});
	                }
	            }, {
	                label: '取消',
	                cssClass:"btn btn-danger",
	                action: function(dialogItself){
	                	dialogItself.close();
	                }
	            }]
			});
		}
		
		//条件查询
		function search_user() {
			//刷新表格
			//$('#user_dg').bootstrapTable("refresh");
			$("#user_dg").bootstrapTable('destroy');//先要将table销毁，否则会保留上次加载的内容
			init_user_dg();//重新初使化表格。
		}
		
	
	</script>

</body>
</html>