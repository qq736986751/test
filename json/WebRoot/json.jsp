<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		//JSON的几种展示方式
  		//1、使用json来展示数组
  		var json1 = [1,2,3,true,"hello"];
  		//展示该对象
  		console.log(json1);
  		//展示该对象里面的内容
  		console.log(json1[3]);
  		//2、使用json来展示对象
  		var json2 = {"uid":1001,"username":"zhangsan","password":"123456"};
  		//展示该对象
  		console.log(json2);
  		//展示里面的内容
  		console.log(json2.uid+","+json2.username+","+json2["password"]);
  		//3、使用json来展示一个对象的集合
  		var json3 = [{"uid":1001,"username":"zhangsan","password":"123456"},
  			{"uid":1002,"username":"lisi","password":"222222"},
  			{"uid":1003,"username":"wangwu","password":"333333"}];
  		console.log(json3);
  		console.log(json3[1]);
  		console.log(json3[1].uid+","+json3[2]["password"]);
  		//4、使用json来展示对象，但是对象里面的属性是集合
  		var json4 = {"uid":1001,"username":{"oldname":"zhangsan","nowname":"zhangsan1"},"wife":["liujie","huangqi"]};
  		console.log(json4);
  		console.log(json4.username.oldname);
  		console.log(json4.wife[1]);
  		//查看这四个json对象的类型
  		console.log(typeof json1);
  		console.log(typeof json2);
  		console.log(typeof json3);
  		console.log(typeof json4);
  		//把json转为字符串
  		var msg = JSON.stringify(json2);
  		console.log(msg+":"+typeof msg);
  		//把json格式的字符串转为json对象
  		var jsonStr = '{"uid":1001,"username":"zhangsan","password":"123456"}';
  		var str2json = JSON.parse(jsonStr);
  		console.log(str2json+":"+typeof str2json);
  		//遍历json对象
  		for(var i in str2json){
  			console.log(i+","+str2json[i]);
  		}
  		
  	</script>
  </head>
  
  <body>

  </body>
</html>