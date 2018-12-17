<%@page import="entity.Cart"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="sum" scope="request" value="0"></c:set>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function clearAll(){
  			var cid="123";
  			var sendDate={
				cid:id
			}
			Ajax('post', 'clearcart.do', sendDate, function(data){
			}, function(error){
		   		console.log(error);
		   		alert(error);
			});
  		}
  	</script>
  </head>
  
  <body>
  	<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" height="50">
		<tr>
			<td width="30%">&nbsp;</td>
			<td align="center"><font color="red" size="+1"><b>你好，<%=session.getAttribute("uname")%>，欢迎光临购物系统
				</b></font></td>
			<td width="30%" align="right" valign="bottom">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3" align="right"><a href="login.jsp">【退出】</a></td>
		</tr>
	</table>
	<hr>
	<center>
	<h1>购物车</h1>
	<table border="1px solid" style="text-align: center;" width="800px">
			<tr>
				<td>编号</td>
				<td>商品名称</td>
				<td>单价</td>
				<td>数量</td>
				<td>合计</td>
				<td>操作</td>
			</tr>
			<c:forEach var="c" items="${cartlist}">
				<tr>
				<td>${c }</td>
				<td>${c.p_name }</td>
				<td>${c.price }</td>
				<td>${c.num }</td>
				<td>${c.num*c.price}</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="6">您的购物车中所有商品总金额:${sum }</td>
			</tr>
		</table>
		<button onclick="clearAll()">清空购物车</button><button>结算</button><button onclick="window.location.href='list.jsp'">继续购物</button>
	</center>
  </body>
</html>
