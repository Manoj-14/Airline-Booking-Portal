<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flights</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="wrapper">
		<h2 class="title">Welcome to Airline Booking Portal</h2>
		<h5 class="sub-title">Please Enter below details to find flights</h5>
		<form action="BookFlight">
			<label for="data">Enter date: </label> <input type="date"
				required="required" placeholder="Date" id="date" name="flightDate" /><br>
			<label for="source">Select Source: </label> <select id="source"
				required="required" name="source">
				<option value="">Select the source</option>
				<c:forEach var="place" items="${places}">
					<option value="${place.id}">${place.name}</option>
				</c:forEach>
			</select><br> <label for="destination">Select Destination: </label> <select
				id="destination" required="required" name="destination">
				<option value="">Select the destination</option>
				<c:forEach var="place" items="${places}">
					<option value="${place.id}">${place.name}</option>
				</c:forEach>
			</select><br> <label for="no_of_passengers">Total Number of
				Passengers: </label> <input type="number" required="required"
				placeholder="No of Passengers" id="no_of_passengers" max="5"
				name="noOfPassengers" /><br> <input type="submit"
				value="Find Flight" />
		</form>
	</div>
</body>
</html>