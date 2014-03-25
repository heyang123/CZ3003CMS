<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<div class="container">
			<header>
				<h1><span> 
				<%
 					if (session.getAttribute("username") != null) {
 						out.println("Welcome, " + session.getAttribute("username") + "!");
 					}
 				%>
 				</span> Call Center Agency Record System</h1>
            </header>       
      <div  class="form">
    		<form id="contactform" method="post" action="InfoRecordServlet"> 
    			<p class="contact"><label for="name">Name</label></p> 
    			<input id="name" name="name" placeholder="First and last name" required="" tabindex="1" type="text"> 
    			 
    			<p class="contact"><label for="phoneNumber">Phone Number</label></p> 
    			<input id="phoneNo" name="phoneNo" placeholder="+65 XXXX XXXX" required="" type="text"> 
                
          <p class="contact"><label for="agencyAddress">Agency Address</label></p> 
    			<input id="agencyAddress" name="agencyAddress" placeholder="Agency address" required="" tabindex="2" type="text"> 
    			 
          <p class="contact"><label for="postalCode">Postal Code</label></p> 
    			<input type="text" id="postalCode" name="postalCode" placeholder="666666" required=""> 
         
          <p class="contact"><label for="agencyType">Agency Type</label></p>
          <select class="select-style gender" name="agencyType">
            <option value="1">Emergency Ambulance</option>
            <option value="2">Rescue and Evacuation</option>
            <option value="3">Fire-Flighting</option>
            <option value="4">Gas Leak Control</option>
          </select><br><br>
          <input class="buttom" name="submit" id="submit" tabindex="5" value="Submit" type="submit">
          	<%
 				if (session.getAttribute("recMsg") != null) {
 	   				if (session.getAttribute("recMsg").equals("S")) {
 	   					out.print("<script language='JavaScript' type='text/JavaScript'>alert('Record successfully');</script>");
 	   				} else {
 	   					out.print("<script language='JavaScript' type='text/JavaScript'>alert('Record fail');</script>");
 	   				}
 				}
 			%> 	 
   </form> 
</div>      
</div>

</body>
</html>
