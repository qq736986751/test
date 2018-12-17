<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="ajax.js"></script>
  <script type="text/javascript">
  	function check(val){
  		$ajax({
  			url:"testjson.do",
  			type:"get",
  			data:{
  				
  			},
  			success:function(data){
  				alert(typeof data);
  				for(var i in data){
  					console.log(data[i]);
  				}
  			},
  			error:function(error){
  				alert(error);
  			}
  		});
  	}
  </script>
  </head>
  
  <body>
	<form action="reg.do" method="post">
			用户名：<input type="text" name="username" onblur="check(this.value)"/>
			<span id="span"></span>
			<br />
			密码：<input type="password" name="password" /><br />
			<input type="submit" value="注册"/>
		</form>
  </body>
</html>