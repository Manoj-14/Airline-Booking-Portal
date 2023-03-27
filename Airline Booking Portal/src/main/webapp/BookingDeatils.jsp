<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking deatils</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%
	String flightId = request.getParameter("flightId");
	int nop = Integer.parseInt(request.getParameter("nop"));
	String date = request.getParameter("flightdate");
	pageContext.setAttribute("flightdate", date);
	pageContext.setAttribute("nop", nop);
	pageContext.setAttribute("flightId", flightId);
	%>
	<div class="wrapper">
		<h2 class="title">Enter Personal details</h2>
		<form action="MakePayment?flightdate=${flightdate}&flightId=${flightId}" method="post">
			<%
			int i = 0;
			pageContext.setAttribute("i", i);
			%>
			<%
			while (i++ < nop) {
			%>
			<label for="passenger<%=i%>">Passenger <%=i%> Name:
			</label> <input id="passenger<%=i%>" name="names" placeholder="Name"
				required="required" /><br> <label for="passenger<%=i%>age">Passenger
				<%=i%> Age:
			</label> <input id="passenger<%=i%>age" name="ages" placeholder="Age"
				required="required" /><br>
			<%
			}
			%>
			<input type="submit" value="Submit and go to payment" />
		</form>
	</div>
</body>
</html>