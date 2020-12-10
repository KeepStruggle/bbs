<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header.jsp"  %>
<script type="text/javascript" src="scripts/jquery-1.12.4.js"></script>
<script type="text/javascript">
  function check(){
		var title = document.getElementById("title");
		var content = document.getElementById("content");
		if(title.value == ""){
			alert("标题不能为空！");
			return false;
		}else if(content.value == ""){
			alert("内容不能为空！");
			return false;
		}
		return true;
	}
  
  function show(){
	  $("#tname").html($('#testSelect option:selected').val());
  }
  
  	//根据后台传过来的值动态设置下拉框选中
  $(function(){
	  var tname=$("#testSelect1").val();
	  $("#testSelect option[value='"+tname+"']").attr("selected", true);
	    
  })
</script>
  
 <body>
 <form action="MessageServlet?action=add" method="post" onsubmit="return check()">
	<div id="main">
		<div class="mainbox">			
			<div class="menu">
				<span>当前用户：<a href="main.jsp">${user.uname }</a></span>
				<span><a href="">发短消息</a></span>
				<span><a href="">退出</a></span>
			</div>
			<div class="content">
				<div class="message">
					
						<div class="tmenu">
							<ul class="clearfix">
								<li>
									发送给：
									<span id="tname">
										<c:if test="${!empty message }">${fname }</c:if>
										<c:if test="${empty message }">zhangsan</c:if>		
									</span>
									<input type="hidden" id="testSelect1" value="${fname }" />
									
									<select name="toUser" onchange="show()" id="testSelect">
										<option selected="selected" value="zhangsan">zhangsan</option>
										<option value="lisi">lisi</option>
										<option value="wangwu">wangwu</option>

									</select>
								</li>								
								<li>标题：<input type="text" name="title" id="title" value="${message.title }"/></li>
							</ul>
						</div>
						<div class="view">
							<textarea name="content" id="content"></textarea>
							<div class="send"><input type="submit" name="submit" value=" " /></div>
						</div>
					
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>
