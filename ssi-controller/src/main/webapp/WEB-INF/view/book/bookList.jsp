<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<!-- datagrid -->
	<table id="user_dg"></table>

	<script type="text/javascript">
		//初始化数据表格
		$('#user_dg').bootstrapTable({
			url:"<%=request.getContextPath() %>/selectBookList.jhtml",
			dataType:"json",
			//请求方式
			method:"post",
			//必须的，操你大爷！！！！不然会造成中文乱码
			contentType: "application/x-www-form-urlencoded",
			//斑马线
			striped:true,
			//设置分页
			/* pagination:true,
			paginationLoop:true,
			pageNumber:1,
			pageSize:5,
			pageList:[3,5,8,10], */
			//工具条
			/* toolbar:"#book_tb", */
			//设置后台分页
			/* sidePagination:"server", */
			//开启搜索框
			/* search:true, */
			//显示刷新按钮
			showRefresh:true,
		    columns: [{
		        checkbox:true
		    }, {
		        field: 'bookId',
		        title: '主键'
		    }, {
		        field: 'bookName',
		        title: '书籍名称'
		    }, {
		        field: 'bookPrice',
		        title: '价格'
		    }, <%-- {
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
		    }, {
		        field: 'cz',
		        title: '操作',
		        formatter:function(value, row, index) {
		        	var zc_btn_group = '<div class="btn-group">'
		        	+ '<button type="button" class="btn btn-xs btn-success" onclick="show_edit_dialog(\'' + row.bookID + '\')">编辑</button>'
		        	+ '</div>&nbsp;&nbsp;'
		        	+ '<div class="btn-group">'
		        	+ '<button type="button" class="btn btn-xs btn-danger" onclick="delete_checked_book(\'' + row.bookID + '\')">删除</button>'
		        	+ '</div>';
		        	return zc_btn_group;
		        }
		    } ]
		});--%>
	
	</script>
</body>
</html>