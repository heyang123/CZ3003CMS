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
 <%
 	if (session.getAttribute("username") != null) {
 		out.println("Welcome, " + session.getAttribute("username") + "!");
 	}
 %> <br />
   Name: <br /><input type="text" name="name" /><br />
   Phone Number: <br /><input type="text" name="phoneNo" /><br />
   Agency Address: <br /><input type="text" name="agencyAddress" /><br />
   Postal Code: <br /><input type="text" name="postalCode" /><br />
   Agency Type: <br />
   <select name="agencyType">
    <option value="1">Emergency Ambulance</option>
    <option value="2">Rescue and Evacuation</option>
    <option value="3">Fire-Flighting</option>
    <option value="4">Gas Leak Control</option>
   </select><br />
   <input type="submit" value="Submit" /><br />
 <%
 	if (session.getAttribute("recMsg") != null) {
 		out.println(session.getAttribute("recMsg"));
 	}
 %>
 </form>
</body>
</html>