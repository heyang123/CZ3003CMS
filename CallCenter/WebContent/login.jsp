<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Login</title>
</head>
<body>
 <form method="post" action="LoginServlet">
  Username: <br /><input type="text" id="username" name="username" /><br />
  Password: <br /><input type="password" id="password" name="password" /><br />
  <input type="submit" value="login" name = "submit" />
 </form>
</body>
</html>