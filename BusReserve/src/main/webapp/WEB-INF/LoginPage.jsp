<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
h1{
	font-family: cursive;
	font-weight: bolder;
}
body {
	font-family: Arial, Helvetica, sans-serif;
	text-align: center;
	background-image: url("Images/bus1.jpg");
	background-size: cover;
	background-color: #cccccc;
	color: white;
}

input[type=text], input[type=password] {
	width: 80%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
}

button {
	background-color: red;
	color: white;
	padding: 12px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 50%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: 20%;
	padding: 12px 20px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}
label{
	text-align: left;
}
h1{
	font-family: cursive;
	font-weight: bolder;
	color:#B82103;
}
</style>
</head>
<body>
<h1 align="center">HEXA BUS RESERVATION</h1>
	<h2 style="margin-top: 100px;">Login Form</h2>

	<form action="checkLogin" method="post">


		<div class="container" style="margin-top: 100px;">
			<table align="center">
				<tr>
					<td><label for="uname"><b>LoginId</b></label></td>
					<td><input type="text" placeholder="Enter LoginId"
						name="uname" required style="padding-left: 10px"></td>
				</tr>
				<tr>
					<td><label for="psw"><b>Password</b></label></td>
					<td><input type="password" placeholder="Enter Password"
						name="psw" required style="padding-right: 10px;"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button type="submit">Login</button>
					</td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>
