<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="footer.jsp"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("../images/light-blue-background.jpg");
} 
 

.container {
	background: lightblue;
	width: 470px;
	margin: 0 auto;
	padding-left: 50px;
	padding-top: 20px;
	padding: 16px;
	background-color: white;
	box-shadow: 5px 10px #888888;
}

* {
	box-sizing: border-box;
}

.info {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=email], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background:white;
}

input[type=email]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

.btn {
    background-color: #008CBA; 
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.btn:hover {
	opacity: 1;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
	align: left;
}
</style>
<script type="text/javascript">
	function fnValidate() {

		var mail = document.getElementById("username").value
		var current = document.getElementById("pwdCurrent").value;
		var newpass = document.getElementById("pwdNew").value;
		var renewpass = document.getElementById("pwdRenew").value;

		if (!(current == newpass)) {
			if ((newpass == renewpass)) {
				location.href = '/changepassword/' + mail + '/' + current + '/'
						+ newpass;

			} else {
				alert('Password mismatch');
			}
		} else {
			alert('New password cannot be same as current password');
		}
	}
</script>

</head>

	<body>
	<center>

	<table>
	<div class=container>
		<h1>Change Password</h1>
			<div class=info>
				<label for="name"><b>User name:</b></label><br> <input type="email"
					placeholder="Enter Your Email" id="username"><br>
				<label for="current password"><b>Current Password<br></b></label> <input type="password"
					placeholder="current password" id="pwdCurrent"><br>
				<label for="new password"><b>New Password<br></b></label> <input type="password"
					placeholder="new password" id="pwdNew"><br>
				<label for="Re-enter password"><b>Re-enter Password<br></b></label> <input type="password"
					placeholder="Re-Enter new password" id="pwdRenew">
			</div>
			
				<input type="submit" value="Save Changes"
					onclick="return fnValidate();" class="btn"></input>
		
		</div>
</table>

</center>
	</body>

</html>