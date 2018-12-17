<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<title>很烦很烦</title>
<script type="text/javascript" src="ajax.js"></script>
<script type="text/javascript">
	function showall() {
		var a=document.getElementById("a");
		$ajax({
			url : "show.do",
			type : "post",
			data : {},
			success : function(data) {
				for ( var i in data) {
					var tr=document.createElement("tr");
					var td=document.createElement("td");
					td.innerText=data[i].empno;
					tr.appendChild(td);
					var td=document.createElement("td");
					td.innerText=data[i].ename;
					tr.appendChild(td);
					var td=document.createElement("td");
					td.innerText=data[i].job;
					tr.appendChild(td);
					var td=document.createElement("td");
					td.innerText=data[i].mgr;
					tr.appendChild(td);
					var td=document.createElement("td");
					td.innerText=data[i].sal;
					tr.appendChild(td);
					var td=document.createElement("td");
					td.innerText=data[i].comm;
					tr.appendChild(td);
					var td=document.createElement("td");
					td.innerText=data[i].hiredate;
					tr.appendChild(td);
					var td=document.createElement("td");
					td.innerText=data[i].deptno;
					tr.appendChild(td);
					a.appendChild(tr);
				}
			},
			error : function(error) {
				alert(error);
			}
		});
		
	}
</script>
</head>

<body>
	<button onclick="showall()">查看EMP表里的东西</button>
	<br>
	<table id="a" border="1px solid">
		
	</table>
</body>
</html>
