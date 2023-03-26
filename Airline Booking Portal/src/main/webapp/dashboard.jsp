<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<div>
		<h2>Admin Details</h2>
	</div>
	<div>
		<h2>Add Places</h2>
		<form action="AddPlace" method="post">
			<label for="place">Enter the Place Name: </label>
			<input type="text" required="required" placeholder="Place" id="place" name="place"/><br>
			<input type="submit" value="Add Place"/>
		</form>
	</div>
	<div>
		<h2>Add flight</h2>
		<form action="AddFlight" method="post">
			<label for="flight_name" >Enter the Flight Name: </label>
			<input type="text" required="required" placeholder="Flight Name" id="flight_name" name="flightName"/><br>
			<label for="no_of_passengers" >Total Number of Passengers: </label>
			<input type="number" required="required" placeholder="No of Passengers" id="no_of_passengers" name="noOfPassengers"/><br>
			<label for="source" >Select Source: </label>
			<select id="source" required="required" name="source">
				<option value="">Select the source</option>
			</select><br>
			<label for="destination" >Select Destination: </label>
			<select id="destination" required="required" name="destination">
				<option value="">Select the destination</option>
			</select><br>
			<input type="submit" value="Add Flight"/>
		</form>
	</div>
	<div>
		<h2>Allot Flight To Date</h2>
		<form action="AddDateOfFlight" method="post">
			<label for="flight">Select Flight: </label>
			<select id="flight" required="required" name="flight">
				<option value="">Select the flight</option>
			</select><br>
			<label for="data">Enter date: </label>
			<input type="date" required="required" placeholder="Date" id="date" name="FlightDate"/><br>
			<input type="submit" value="Allot Flight"/>
		</form>
	</div>
	<div>
		<h2>Get Passenger List</h2>
	</div>
</body>
</html>