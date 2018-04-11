<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	text-align: center;
	
	background-size: cover;

}
div{
background: -webkit-linear-gradient(left, #CDEBEF, white, #CDEBEF, white, #CDEBEF);	
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

span.psw {
	float: right;
	padding-top: 16px;
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
#dlist td,th{
padding: 10px;
text-align: left;
}
</style>
</head>
<body align="center">
	<h1 align="center">HEXA BUS RESERVATION</h1>
	<div>
	<%@include file="Header.jsp"%>
	
		<h2>Bus Schedule</h2>

		<table id="dlist" align="center">

			<c:forEach items="${dlist}" var="d">

				<tr>
					<th>Busid</th>
					<td>${d.bdetail.bid}</td>
					<br>
				</tr>
				<tr>
					<th>Schedule Id</th>
					<td>${d.schId}</td>
					<br>
				</tr>
				<tr>
					<th>No of seats available</th>
					<td>${d.noOfSeatsAvailable}</td>
					<br>
				</tr>
				<tr>
					<th>Date</th>
					<td>${d.dateOfJourney}</td>
					<br>
				</tr>
				<tr>
					<th>price</th>
					<td>${d.bdetail.price}</td>
				</tr>
				<table align="center">
					<tr>
						<td><a href="displayBooking?bid=${d.bdetail.bid}"><button
									style="width: 75px; padding-left: 20px; padding-right: 20px;">Book</button></a></td>
						<td><a href="displayBooking?price=${d.bdetail.price}"></a></td>
					</tr>
				</table>
			</c:forEach>

		</table>
	</div>

</body>


</html>
