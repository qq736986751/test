<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<style type="text/css">
  		span{
  			color:red;
  		}
  	</style>
  	<script type="text/javascript" src="md5.js"></script>
  	<script type="text/javascript">
  		function check(){
  			document.getElementById("span").innerText = "";
  		}
  		alert(hex_md5("wangyang"))
  	</script>
  </head>
  
  <body>
		<form action="login1.do" method="post">
			用户名：<input type="text" name="username" onfocus="check()"/>
			<span id="span"><%=request.getAttribute("error_msg")==null?"":request.getAttribute("error_msg") %></span>
			<br />
			密码：<input type="password" name="password" /><br />
			<input type="submit" value="登录"/>
		</form>
  </body>
</html>