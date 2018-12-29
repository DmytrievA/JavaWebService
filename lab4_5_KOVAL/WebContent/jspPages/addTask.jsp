<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add task</title>
</head>
<body>
<h3>${greeting}</h3>
<form action="/lab4_5_KOVAL/AddTaskServlet" method = "post">
	<input type = "text" name = "title" placeholder = "TaskTitle"/><br/>
	<input type = "text" name = "userName" placeholder = "User Name"/><br/>
	<input type = "text" name = "description" placeholder = "Description"/><br/>
	<input type = "text" name = "startDate" placeholder = "Start Date"/><br/>
	<input type = "text" name = "finishDate" placeholder = "Finish Date"/><br/>
	<input type = "submit" value = "ADD TASK"><br/>
</form>
<div name = "result">
 ${result}
</div>
</body>
</html>