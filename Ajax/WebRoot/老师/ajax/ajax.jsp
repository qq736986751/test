<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
  		//1、获取到XmlHttpRequest对象
  		function getXhr(){
  			var xhr = null;
  			//证明是非IE内核
  			if(window.XMLHttpRequest){
  				xhr = new XMLHttpRequest();
  			//否则就是IE内核
  			}else{
  				xhr = new ActiveXObject("Microsoft.XMLHttp");
  			}
  			return xhr;
  		}
  		//2、发送ajax请求
  		function send(val){
  			//获取对象
  			var xhr = getXhr();
  			//构建我们要发送的信息
  			var url = "checkUsername.do?username="+val;
  			//设置发送模式
  			xhr.open("get", url);
  			//绑定监听器
  			xhr.onreadystatechange = function(){
  				//如果它为4就证明已经完成了数据的前后端的交互并且得到了响应
  				if(xhr.readyState==4){
  					//如果为200，就证明一切正常
  					if(xhr.status==200){
  						//如果正常的话，我们就获取到后台发送过来的数据
  						var msg = xhr.responseText;
  						alert(msg);
  					//如果不是200，就证明服务器异常
  					}else{
  						alert("服务器异常！")
  					}
  				}
  			}
  			//发送
  			xhr.send(null);
  		}
  		function send1(){
  			location.href = "noajax.do";
  		}
  	</script>
</head>
<body>
	<form action="reg.do" method="post">
		用户名：<input type="text" name="username" onblur="send(this.value)" />
		测试非ajax请求：<input type="text" name="username1" onblur="send1()" />
		密码：<input type="password" name="password" /><br /> <input
			type="submit" value="登录" />
	</form>
</body>
</html>