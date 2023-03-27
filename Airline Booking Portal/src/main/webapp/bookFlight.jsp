<%@page import="com.AirlineBookingPortal.Utils.FlightUtil"%>
<%@page import="com.AirlineBookingPortal.model.Flight"%>
<%@page import="java.util.List"%>
<%@page import="com.AirlineBookingPortal.Utils.PlaceUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Flights</title>
</head>
<body>

	<%
	request.getSession();
	String source = PlaceUtil.getPlace(Integer.parseInt(request.getParameter("source"))).getName();
	String destination = PlaceUtil.getPlace(Integer.parseInt(request.getParameter("destination"))).getName();
	String flightdate = request.getParameter("flightDate");
	int nop = Integer.parseInt(request.getParameter("noOfPassengers"));
	pageContext.setAttribute("nop", nop);
	pageContext.setAttribute("source", source);
	pageContext.setAttribute("destination", destination);
	pageContext.setAttribute("flightdate", flightdate);
	
	%>
	<h3>There are ${NoOfFlights} flights from ${source} to
		${destination} are:</h3>
	<c:forEach var="flight" items="${flights}" varStatus="loop">
		<div>
			<p>${loop.index+1}.
				${ flight.flightname} <a
					href="BookingDeatils.jsp?flightdate=${flightdate}&flightId=${flight.getFlightid()}&nop=${nop}">Book</a>
			</p>
		</div>
	</c:forEach>
</body>
</html>