<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Flights</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<main id="find_flight" class="wrapper">
		<h2 class="title">Find Flights</h2>
		<form action="findFlight" method="get">
			<label for="source">Choose The Source: </label>
			<select name="sourceId" id="source" required="true">
				<option value="">Select here</option>
				<option value="SourceId">Src</option>
			</select><br>
			<label for="destination">Choose The Destination: </label>
			<select name="destinationId" id="destination" required="true">
				<option value="">Select here</option>
				<option value="DestinationId">Dest</option>
			</select><br>
			<label for="date">Date for Travel: </label>
			<input type="date" id="date" name="date" placeholder="Date" required="true"/><br>
			<label for="passengers">Number of Passengers: </label>
			<input type="number" id="passengers" name="passengers" placeholder="Total Passengers" required="true"/><br>
			<input type="submit" value="Search"/>	
		</form>
		<p>Or</p>
		<a href="index.html">Go to Home</a>
	</main>
</body>
</html>