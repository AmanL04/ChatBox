<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%if(session.getAttribute("name")==null)
  response.sendRedirect("/WebApp");
%>  

<!DOCTYPE html>
<html>
<%String uname=(String)session.getAttribute("name"); %>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="styles.css">
    <script type="text/javascript" src="check.js"></script>
    <title>The Chat Box</title>
    <link rel="shortcut icon" href="icon.jpeg" />
    <script>
     	setInterval(reloaddata, 3000);
    </script>
</head>
<body>
<p id="result"></p>
Welcome, <%=uname %>
<div class="logout-div" align="right"><a href="logout.jsp" class="logout-chat">LOGOUT</a></div>
<div id="list">
	<div id="content"></div>
	<input style="display:none" type="text" id="u" value="<%=uname %>">
	<textarea id="h" style="width: 100%;height: 10%"></textarea>
	<input type="text" value="send" onclick="addText();">
	
</div>
</body>
</html>