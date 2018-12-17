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
<script type="text/javascript" src="ajax.js"></script>
<script type="text/javascript">
		setInterval(function(){
			$ajax({
				url:"top.do",
				type:"post",
				data:{},
				success : function(data) {
					var str = "";
					var s = document.getElementById("span");
					for(i in data){
						str+="<p>商品名称："+data[i].p_name+";销量："+data[i].p_sale_num+"</p>";
					}
					s.innerHTML=str;
				},
				error : function(error) {
					alert(error);
				}
			});
		},2000);
	</script>
</head>

<body>
	<div>
		<p>当前销量最好的商品是：</p>
		<span id="span"></span>
	</div>
</body>
</html>
