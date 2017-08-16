<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link type="text/css" href="<%=request.getContextPath() %>/js/css/demo.css" rel="stylesheet">
	<link type="text/css" href="<%=request.getContextPath() %>/js/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.ztree.all.js"></script>


		<h1>哈哈哈 ${t_userId}</h1>
	<ul id="myTree" class="ztree"></ul>
				
			<script type="text/javascript">
	
	$(function () {
		builemyTree()
		   /* queryTree(); */
		 });

		 function init() {
		   builemyTree();
		 }

		var zTreeObj;
		//ZTREE
		 function builemyTree() {
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
		    // onClick: zTreeOnClick
		  }
		};

	/* 	   
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
		 ]; */
		   $.ajax({
			   url:"<%=request.getContextPath()%>/selectUserRoleListJson.jhtml",
			   type:"post",
			   data:{userID:"${t_userId}"},
			   dataType:"json",
			  	success:function(result){
			  		zNodes = result;
			  		
			  		 zTreeObj=$.fn.zTree.init($("#myTree"), setting, zNodes);
			  	}
			   
			   
		   })
		}
		   //获取被选中的树节点
		   function get_selection_tree_nodes() {
			   var role_json_array = [];
			   var nodes = zTreeObj.getCheckedNodes(true);
			   for (var i = 0; i < nodes.length; i++) {
				   var role_obj = {userID:"${t_userId}", roleID:nodes[i].id};
				   role_json_array.push(role_obj);
				   //alert(nodes[i].name + ">>" + nodes[i].id);
			   }
			   return role_json_array;
			   
		   }

	    
	    
	     

		 
		
		
		<%-- function queryTree(){
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

