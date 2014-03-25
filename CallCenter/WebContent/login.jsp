<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
</head>
<body>
<div class="container">
			<header>
				<h1><span>Welcome! Login Please!</span> Call Center Login System</h1>
            </header>       
      <div  class="form">
    		<form id="contactform" method="post" action="LoginServlet"> 
    			<p class="contact"><label for="username">Username</label></p> 
    			<input id="username" name="username" placeholder="Your username" required="" tabindex="1" type="text"> 
    			 
    			<p class="contact"><label for="password">Password</label></p> 
    			<input type="password" id="password" name="password" required="" placeholder="Your password"> 
                
          <input class="buttom" name="login" id="login" tabindex="5" value="Login" type="submit">
          <br />
          	<%
   			if (session.getAttribute("loginMsg") != null) {
   				if (session.getAttribute("loginMsg").equals("F")) {
   					out.print("<script language='JavaScript' type='text/JavaScript'>alert('Wrong username and password match');</script>");
   				} else {
   					out.print("<script language='JavaScript' type='text/JavaScript'>alert('Login successfully');</script>");
   				}
   			}
   			%> 	 
   </form> 
</div>      
</div>

</body>
</html>