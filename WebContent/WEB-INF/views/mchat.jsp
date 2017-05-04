<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	System.out.println(path);
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println(basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	#main{
		border: 1px solid black;
		background-color: green;
		height: 500px;
		width: 600px;
	}
	
	#head{
		background-color:grey;
		height: 70px;
	}
	
	#center{
		background-color:white;
		height: 400px;
	}
	
	#bottom{
		background-color: black;
		height: 30px;
		text-align: center;
	}
</style>
</head>
<body>
	<div id="main">
		<div id="head">
			head
		</div>
		<div id="center">
			23232
		</div>
		<div id="bottom">
			<input id="msg" type="text" >
			<input type="button" value="发送" onclick="javascript:sendMsg()">
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>resources/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/js/mchat.js"></script>
</body>
</html>