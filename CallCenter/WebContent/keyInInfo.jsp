<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
 <form method="post" action="InfoRecordServlet">
   Name: <br /><input type="text" name="name" /><br />
   Mobile Number: <br /><input type="text" name="mobileNumber" /><br />
   Location: <br /><input type="text" name="location" /><br />
   Type of assistance requested: <br /><input type="text" name="type" /><br/>
   <input type="submit" value="submit" />
 </form>
</body>
</html>