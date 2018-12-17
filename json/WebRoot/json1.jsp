<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  	<script>
  		//json的展示方法
  		//1、使用json来展示数组
  		var json1=[1,2,true,"liujianghui"];
  		console.log(json1);
  		console.log(json1[2]);
  		//2、使用json来展示对象
  		var json2={"uid":1001,"uname":"liujianghui","pwd":"assddasd"};
  		console.log(json2);
  		console.log(json2.uid+","+json2.uname+","+json2.pwd);
  		//3、展示集合里面有对象
  		var json3=[{"uid":1001,"uname":"liujianghui","pwd":"assddasd"},
  		{"uid":1001,"uname":"liujianghui","pwd":"assddasd"},
  		{"uid":1001,"uname":"liujianghui","pwd":"assddasd"}];
  		console.log(json3);
  		console.log(json3[0]);
  		console.log(json3[1].uid);
  		console.log(json3[2]["uname"]);
  		//4、展示对象里面有数组
  		var json4={"uid":1001,"username":{"oldname":"liusuwan","nowname":"liujianghi"},"wife":["stone","ashin"]};
  		console.log(json4);
  		console.log(json4.username.oldname);
  		console.log(json4.wife[1]);
  		//这四个变量的类型都是对象
  		console.log(typeof json1);
  		console.log(typeof json2);
  		console.log(typeof json3);
  		console.log(typeof json4);
  		//将json(是一种通用的格式、标准)转为字符串
  		var msg=JSON.stringify(json2);
  		console.log(msg+":"+typeof msg)
  		//将字符串转为json
  		var jsonStr = '{"uid":1001,"uname":"liujianghui","pwd":"assddasd"}';
  		var str2json = JSON.parse(jsonStr);
  		console.log(str2json+":"+typeof str2json);
  		//用for循环遍历json对象
  		for(var jso in str2json){
  			console.log(jso+","+str2json[jso]);
  		}
  	</script>
  <body>
  
  </body>
</html>
