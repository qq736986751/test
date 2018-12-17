<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<script type="text/javascript">
		function clears(){
			document.getElementById("span1").innerText="";
		}
	</script>
</head>
<body>
	<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" height="50">
	<tr>
		<td width="30%">&nbsp;</td>
		<td align="center"><font color="red" size="+1"><b>欢迎光临购物系统</b></font></td>
		<td width="30%" align="right" valign="bottom"><a href="register.html"><span style="text-decoration:none">还没有账号，马上注册</span></a></td>
	</tr>
	</table>
	<hr>
	<h2 align="center">
		用户登录
		<form action="login.do" method="post">
			用户名：<input type="text" name="username" onfocus="clears();"><br> 
			密&nbsp;&nbsp;码：<input type="password" name="password"><br><br>
			<input type="submit" value="登录"><br>
			<span style="color:red" id="span1">
			<%-- <%=request.getAttribute("message")==null?"":request.getAttribute("message") %> --%>
			${message==null?"":message}
			</span>
		</form>
	</h2>
</body>
</html>
