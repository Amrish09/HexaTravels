<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<style type="text/css">
     body{ 
     text-align:center;
     
     }
     td{
     
     font-family: Arial, Helvetica, sans-serif;
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
#ilist td,th{
padding: 10px;
text-align: left;
}
div{
background: -webkit-linear-gradient(left, #CDEBEF, white, #CDEBEF, white, #CDEBEF);	
}
</style>
<script>
     function calcPrice(price, seats){
    	 var total = price* seats;
    	 document.getElementById("tot").innerHTML = total;
     }
   </script>

</head>
<body>
<h1 align="center">HEXA BUS RESERVATION</h1>
<div><%@include file="Header.jsp"%>
	<h2>Bus price</h2>
	<form action="displayUserBook">
		<table id="ilist" align="center">
			<c:forEach items="${ilist}" var="i">
				<tr>
					<th>Schedule Id</th>
					<td>${i.schId}</td>
				</tr>
				<tr>
					<th>price</th>
					<td>${i.bdetail.price}</td>
				</tr>
				<tr>
					<th>No of seats required</th>
					<td><input type="text" name="noofseatsrequired"
						onkeyup="calcPrice(${i.bdetail.price}, this.value);"></td>
				</tr>
				<tr>
					<th>Total price</th>
					<td><span id="tot"></span></td>
				</tr>
				<input type="hidden" name="schId" value="${i.schId}" />
				<input type="hidden" name="uname"
					value="${sessionScope.log.loginId}" />
				<tr><td></td>
				<td>			
				<input type="submit" value="Confirm" style="padding-right:20px;
				padding-left:20px;
				padding-top:15px;
				padding-bottom:15px;"/>
				</td></tr>
			</c:forEach>
		</table>

	</form>
</div>
</body>
</html>
