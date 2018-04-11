
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
      <c:if test="${sessionScope.log eq null}" >
      <c:redirect url="/Login"></c:redirect></c:if>
      <h2 align="left">Welcome ${sessionScope.log.userName}</h2>
      <c:if test="${sessionScope.log ne null}" >
      <a Style="text-align: right; float: right;" href="logout">Logout</a><br><br><br>
      <a Style="text-align: right; float: right;" href="Main">Home</a></c:if>
      
</header>
	
	