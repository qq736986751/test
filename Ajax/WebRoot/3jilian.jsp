<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<select>
  		<option value=-1>--省--</option>
  	</select>
  	<select>
  		<option value=-1>--市--</option>
  	</select>
  	<select>
  		<option value=-1>--区--</option>
  	</select>
  </body>
</html>
