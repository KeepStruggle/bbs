<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="header.jsp"  %>
<html>
  <head>    
    <title>读短消息</title>	    
  </head>
	<body>
		<div id="main">
			<div class="mainbox">
				<div class="title readMessage png"></div>
				<div class="menu">
					<span>当前用户：<a href="main.jsp">${user.uname }</a></span>
					<span><a href="">发短消息</a></span>
					<span><a href="">退出</a></span>
				</div>
				<div class="content">
					<div class="message">
						
							<div class="tmenu">
								<ul class="clearfix">
									<li>题目：${message.title }</li>
									<li>来自：${tname }</li>
									<li>时间：${message.date }</li>									
								</ul>
							</div>
					  	 	<div class="view">
								<p>${message.content }</p>
							</div>
				  	 	
					</div>
				</div>
				<div style=" text-align:center;"><a href="main.jsp"><input type="button" value="返回" style="background-color: #3C9EC2;border: none;color: white;padding: 10px 25px;text-align: center;border-radius:45%;font-size: 16px;" ></a></div>
			</div>
		</div>
	</body>
</html>
