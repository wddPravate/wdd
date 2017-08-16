<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Insert title here</title>
 <!-- Bootstrap -->
    <link href="<%=request.getContextPath() %>/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- tab页（选项卡）组件 -->
    <link href="<%=request.getContextPath() %>/js/bootStrap-addTabs/bootstrap.addtabs.css" rel="stylesheet">

	<link href="<%=request.getContextPath() %>/js/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/js/bootstrap-dialog/dist/css/bootstrap-dialog.min.css" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/js/bootstrap-fileinput/css/fileinput.css" />

	<link type="text/css" href="<%=request.getContextPath() %>/js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<link type="text/css" href="<%=request.getContextPath() %>/js/css/demo.css" rel="stylesheet">
	<link type="text/css" href="<%=request.getContextPath() %>/js/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
<style type="text/css">
	.lie {
		/*height:300px;*/
		background: #ffffee;
	}
	.navbar {
		height: 52px;
		background: #000000;
	}
	.container-fluid {
		top: 48px;
		position: relative;
	}
	#nav_h3 {
		text-align:center;
		color: gray;
	}
	
</style>
</head>
<body>


	<!-- 导航条 -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<h3 id="nav_h3">金科教育企业平台</h3>
	</nav>
	
	<!-- 流式布局 -->
	<div class="container-fluid">
		<!-- 栅格系统 -->
		<div class="row">
			<!-- 添加列 -->
			<!-- <div class="col-xs-* lie">
				玩呢，演示一下栅格系统
			</div> -->
		</div>
		<div class="row">
			<!-- 添加列 -->
			<div class="col-xs-3 lie">
				<!-- 添加列表组（树菜单） -->
				<div id="tree"></div>
			</div>
			<div class="col-xs-6 lie">
				<div id="content-div">
					<!-- 选项卡 -->
					<div id="tabs">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#home" aria-controls="home" role="tab" data-toggle="tab">主页</a></li>
                        </ul>
                        <!-- Tab panes（放置结果页面） -->
                        <div class="tab-content">
                        </div>
                    </div>
				</div>
			</div>
			
			<div class="col-xs-3 lie">
				
			</div>
		</div>
</div>				


<!-- jquery -->
	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootStrap-addTabs/bootstrap.addtabs.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap-treeview/dist/bootstrap-treeview.min.js"></script>
	    
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-table/dist/bootstrap-table.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-dialog/dist/js/bootstrap-dialog.min.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-fileinput/js/fileinput.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-fileinput/js/locales/zh.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/dateformat/formatDatebox.js"></script>
	
	<!-- 加载ajax重定向设置文件 -->
	<script type="text/javascript" src="js/ajaxSetup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.ztree.all.js"></script>
	
	<!-- treegrid -->
	<script type="text/javascript" src="js/jquery-treegrid/js/jquery.treegrid.min.js"></script>
	<script type="text/javascript" src="js/jquery-treegrid/js/jquery.treegrid.bootstrap3.js"></script>
	<script type="text/javascript" src="js/jquery-treegrid/extension/jquery.treegrid.extension.js"></script>
	
	<script type="text/javascript">
	var tree_data = [
	                 	{text:"用户管理",
	                 		href:"<%=request.getContextPath() %>/toBootStrap.jhtml",
	                 		state: {
	                 		    selected: true
	                 		  },},
	                 	{text:"角色管理",
	                 		href:"<%=request.getContextPath() %>/role/toRoleList.jhtml",},
	                 	{text:"品牌管理",
	                 		href:"sdsds",},
	                 	{text:"员工管理",
	                 		href:"sdsds",},
	                 	{text:"部门管理",
	                 		href:"sdsds",},
	                 ];
	
	//初始化树
	$('#tree').treeview({
		data:getTreeData(),
		onNodeSelected:function(event, node) {
			if (null != node.href && "" != node.href) {
				//发送ajax请求
        		$.ajax({
        			url:"<%=request.getContextPath() %>" + node.href,
        			success:function(data) {
        				$.addtabs.add({id:node.text,title:node.text,content:data});
        			}
        		});
			}
		}
	});
	
	function getTreeData() {
		var tree_data = [];
		//发送ajax请求
		$.ajax({
			async:false,//请求为同步
			url:"<%=request.getContextPath() %>/role/selectTreeListJson.jhtml",
			data:{userID:"${userInfo.userID }"},
			dataType:"json",
			success:function(data) {
				tree_data = data;
			}
		});
		return tree_data
	}
	
	/* $(function () {
		   init();
		   queryTree();
		 });
 *//* 
		 function init() {
		   builemyTree();
		 }
 */
		//ZTREE
		/*  function builemyTree() {
		    var setting = {
		    check:{enable:true},
		     view: {
		       showIcon: true//设置 zTree 是否显示节点的图标。
		       },
		     data: {
		       simpleData: {
		         enable: true
		        }
		    },
		    callback: {
		     // beforeExpand: beforeExpand,
		     // onExpand: onExpand,
		     onClick: zTreeOnClick
		  }
		}

		    
		var zNodes =[
		 { id:1, pId:0, name:"课程目录", open:true},
		 { id:11, pId:1, name:"技术知识课程", open:true},
		 { id:111, pId:11, name:"php语言", },
		 { id:112, pId:11, name:"java从入门到放弃", },
		 { id:113, pId:11, name:"java核心思想", },
		 { id:114, pId:11, name:"netty核心技术", },
		 { id:115, pId:11, name:"c++基础知识详解", },
		 { id:12, pId:1, name:"著名讲师", open:true},
		 { id:121, pId:12, name:"陈建辉"},
		 { id:122, pId:12, name:"杨树炎"},
		 { id:123, pId:12, name:"郭秀秀"},
		 { id:13, pId:1, name:"金科F4", open:true},
		 { id:131, pId:13, name:"邵国栋"},
		 { id:132, pId:13, name:"杨占宁"},
		 { id:133, pId:13, name:"石巍严"},
		 { id:134, pId:13, name:"于笑杨"}
		 ];
		    
		    $.fn.zTree.init($("#myTree"), setting, zNodes);
		    
		     function zTreeOnClick(event, treeId, treeNode) {
		     //这里定义点击书中节点时，相应的页面其他的操作，示例：
		     // 每次点击节点后， 弹出该节点的 tId、name 的信息
		     alert(treeNode.tId + ", " + treeNode.name);
		     };

		 } */
		
		
	<%-- 	function queryTree(){
			   var setting = {
					    check:{enable:true},
					     view: {
					       showIcon: true//设置 zTree 是否显示节点的图标。
					       },
					     data: {
					       simpleData: {
					         enable: true
					        }
					    }/* ,
					    callback: {
					     // beforeExpand: beforeExpand,
					     // onExpand: onExpand,
					     onClick: zTreeOnClick
					  } */
					}
			var zNodes="";
			$.ajax({
				async:false,
				url:"<%=request.getContextPath()%>/queryTree.jhtml",
				type:"post",
				dataType:"json",
				success:function(result){
					zNodes=result;
				}
			
			});
			alert(zNodes);
			 $.fn.zTree.init($("#yourTree"), setting, zNodes);
			
		} --%>
	
	</script>
	
	
</body>
</html>