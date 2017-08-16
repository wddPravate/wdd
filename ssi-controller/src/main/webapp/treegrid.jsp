<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
颈部惊喜一部以外
	<table id="dddd2">
	
	</table>
<script type="text/javascript">
  //$('.tree').treegrid({treeColumn:1});
  
  $(document).ready(function () {
            $('#dddd2').treegridData({
                id: 'Id',
                parentColumn: 'pid',
                type: "GET", //请求数据的ajax类型
                url: '<%=request.getContextPath() %>/user/getJson.jhtml',   //请求数据的ajax的url
                /* data:[{Id:1, Name:"系统管理", Desc:"lala"},
                      {Id:2, Name:"用户管理", Desc:"lala", pid:1},
                      {Id:3, Name:"角色管理", Desc:"lala", pid:1},
                      {Id:4, Name:"权限管理", Desc:"lala", pid:1},
                      {Id:5, Name:"报表中心", Desc:"lala"},
                      {Id:6, Name:"报表管理", Desc:"lala", pid:5},], */
                ajaxParams: {}, //请求数据的ajax的data属性
                expandColumn: null,//在哪一列上面显示展开按钮
                striped: true,   //是否各行渐变色
                bordered: true,  //是否显示边框
                //expandAll: false,  //是否全部展开
                columns: [
                    {
                        title: '机构名称',
                        field: 'Name'
                    }
                ]
            });
        });
</script>
</body>
</html>