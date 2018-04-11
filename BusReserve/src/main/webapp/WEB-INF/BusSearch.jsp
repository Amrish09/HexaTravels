<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

body {font-family: Arial, Helvetica, sans-serif;
    text-align: center;
    background-image: url("Images/bus6.jpg");
	 background-size: cover;
}
input[type=submit] {
	color:red;
}

label{
	color: white;
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
    margin-left:30px 30px;
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

h1{
	font-family: cursive;
	font-weight: bolder;
	color:#B82103;
}
header a{
	background-color:red;
	color:white;
	padding:5px;
	box-shadowing:5px 5px 5px black;
	border-radius:5px;
	line-height:30px;
	text-decoration:none;
}

</style>
</head>
<body>
<h1 align="center">HEXA BUS RESERVATION</h1>
<%@include file="Header.jsp"%>


<div>
<form  action="displaySchedule">
<table align="center" style="text-align:left;">
  <tr>
  <th> <label for="source"><b>Source    </b></label></th>
  <td> <input type="text" placeholder="Enter source" name="src" required><br></td></tr>

   <tr> 
   <th><label for="dest"><b>Destination</b></label></th>
   <td><input type="text" placeholder="Enter destination" name="dest" required><br></td></tr>
        
    <tr>
    <th><label for="doj"><b>DateOfJourney</b></label></th>
    <td><input type="text" placeholder="YYYY-MM-DD" name="doj" required><br></td>
    </tr>
    </table>
    <table align="center">
    <tr><td style="text-align: right;"><button type="submit" style="padding-right:100px;">Search</button></td></tr>
    </table>
    
    
 
</form>
</div>
</body>

</html>
