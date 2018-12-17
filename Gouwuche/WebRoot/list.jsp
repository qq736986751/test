<%@page import="entity.Product"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="ajax.js">
	
</script>
	<script type="text/javascript">
		function addGou(obj){
			var id=obj.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.innerText;
			var sendDate={
				cid:id
			}
			Ajax('post', 'cart.do', sendDate, function(data){
			}, function(error){
		   		console.log(error);
		   		alert(error)
			});
		}
	</script>
</head>
<body>
	<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" height="50">
		<tr>
			<td width="30%">&nbsp;</td>
			<td align="center"><font color="red" size="+1"><b>你好，${uname }，欢迎光临购物系统
				</b></font></td>
			<td width="30%" align="right" valign="bottom">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3" align="right"><a href="login.jsp">【退出】</a></td>
		</tr>
	</table>
	<hr>
	<center>
		<table border="1px solid" style="text-align: center;" width="800px">
			<tr>
				<td>编号</td>
				<td>图片</td>
				<td>产品名称</td>
				<td>添加到购物车</td>
			</tr>
			<c:forEach var="p" items="${products}">
				<tr>
					<td>${p.id}</td>
					<td><img src="images/${p.pic}"></td>
					<td>${p.name}</td>
					<td><button style="background: none;border:none" onclick="addGou(this)">添加到购物车</button></td>
				</tr>
			</c:forEach>
		</table>
		<form method="post" action="showcart.do">
			<input type="submit" value="查看购物车" style="background: none;border: none">
		</form>
	</center>
</body>
</html>
