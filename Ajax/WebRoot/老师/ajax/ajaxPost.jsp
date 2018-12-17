<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
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
  		function check(val){
  			//获取对象
  			var xhr = getXhr();
  			//构建我们要发送的信息，post里面的url变成了具体的值得拼接
  			var url = "username="+val;
  			//设置发送模式，post请求的话，open方法里面的第一个参数改为post，第二个参数变成了请求名，不再附带值
  			xhr.open("post","checkUsername.do");
  			//设置post请求的抬头，post请求一定要加这句话，并且不能放在open前面
  			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
  			//绑定监听器
  			xhr.onreadystatechange = function(){
  				//如果它为4就证明已经完成了数据的前后端的交互并且得到了响应
  				if(xhr.readyState==4){
  					//如果为200，就证明一切正常
  					if(xhr.status==200){
  						//如果正常的话，我们就获取到后台发送过来的数据
  						var msg = xhr.responseText;
  						document.getElementById("span").innerHTML = msg;
  					//如果不是200，就证明服务器异常
  					}else{
  						document.getElementById("span").innerHTML = "服务器异常";
  					}
  				}
  			}
  			document.getElementById("span").innerHTML = "验证中...";
  			//发送，post请求在send的时候，需要加url
  			xhr.send(url);
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