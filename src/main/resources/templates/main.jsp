<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ include file="header.jsp"  %>
<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"MessageServlet",
			dataType:"json",
			data:{action:"list"},
			type:"post",
			success:function(data){
				//循环数据
				var html="";
				$(data).each(function(i,v){
					html+="<li class='unReaded'><em>"+v.date+"</em><em><a href='MessageServlet?action=find&id="+v.id+"'>回信</a></em><em><a href='javascript:void(0)' onclick='del(this,"+v.id+")'>删除</a></em><p><strong><a href='MessageServlet?action=show&id="+v.id+"'>"+v.title+"</a></strong></p></li>";
				});
				$("ul").html(html);
			}
		});
	})
	
	function del(obj, id){
		//确认是否删除
		if(confirm("确认要删除吗？")){
			$.ajax({
				url:"MessageServlet",
				data:{action:"delete",id:id},
				type:"post",
				dataType:"text",
				success:function(data){
					if(data=="true"){
						//删除成功，单春当前li
						var li=$(obj).parent().parent();//当前获得的a标签问dom对象，需要将其转成jQuery对象
						alert("删除成功");
						li.remove();
					}else{
						//删除失败
						alert("删除失败");
					}
				}
			})
		}
	}
</script>
<body>
<div id="main">
	<div class="mainbox">
		<div class="title myMessage png"></div>		
		<div class="menu">
			<span>当前用户：<a href="main.jsp">${user.uname }</a></span>
			<span><a href="newMsg.jsp">发短消息</a></span>
			<span><a href="">退出</a></span>
		</div>
		<div id="error"></div>
		<div class="content messageList">
			<ul>

		  	 		<!-- <li class="unReaded">
		  	 		<em>时间</em>
		  	 		<em><a href="">回信</a></em>
					<em><a href="">删除</a></em>
					<p>
						<strong><a href="">主题1</a></strong>
						短信内容 1
					</p>
			  	   </li> -->
		  	 </ul>
		</div>
	</div>
</div>
</body>
</html>
