<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	text-align: center;
}

input[type=text], input[type=password] {
	width: 30%;
	padding: 12px 100px;
	margin-left: auto;
	display: inline-block;
	border: 1px solid #ccc;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 20px 50px;
	margin-left: 30px 30px;
	border: none;
	cursor: pointer;
	width: 10%;
	text-align: center;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: 20%;
	padding: 12px 20px;
	background-color: #f44336;
}
h1 {
	font-family: cursive;
	font-weight: bolder;
	color: #B82103;
}

header a {
	background-color: red;
	color: white;
	padding: 5px;
	box-shadowing: 5px 5px 5px black;
	border-radius: 5px;
	line-height: 30px;
	text-decoration: none;
}
#llist td,th{
padding: 15px;
text-align: left;
size: 30px;
}
div{
background: -webkit-linear-gradient(left, #CDEBEF, white, #CDEBEF, white, #CDEBEF);	
}
</style>
<body>
	<h1 align="center">HEXA BUS RESERVATION</h1>
<div>	<%@include file="Header.jsp"%>
<h3 align="center"> Your booking is confirmed</h3>

	<h2 align="center">Booking Details</h2>
    
	<form>

		<table id="llist" align="center">
			<c:forEach items="${llist}" var="l">
				<tr>
					<th>Uname</th>
					<td>${l.login.userName}</td>
				</tr>
				<tr>
					<th>loginId</th>
					<td>${l.login.loginId}</td>
				</tr>
				<tr>
					<th>Booking Id</th>
					<td>${l.bookingId}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	</div>
</body>
</html>
