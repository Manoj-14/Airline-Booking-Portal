<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Dashboard</title>
</head>
<body>
	<div id="admin-info">
		<h2 class="title">Admin Details</h2>
		<c:set var="admin" value="${admin}" />
		<p>Name: ${admin.name }</p>
		<p>Email: ${admin.username }</p>
	</div>
	<div class="dashboard-wrapper">
		<div>
			<h2 class="title">Add Places</h2>
			<form action="AddPlace" method="post">
				<label for="place">Enter the Place Name: </label> <input type="text"
					required="required" placeholder="Place" id="place" name="place" /><br>
				<input type="submit" value="Add Place" />
			</form>
		</div>
		<div>
			<h2 class="title">Places in database</h2>
			<table border=2>
				<tr>
					<th>Place Names</th>
				</tr>

				<c:forEach var="place" items="${places}">
					<tr>
						<td>${place.name}</td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>
	<div class="dashboard-wrapper">
		<div>
			<h2 class="title">Add flight</h2>
			<form action="AddFlight" method="post">
				<label for="flight_name">Enter the Flight Name: </label> <input
					type="text" required="required" placeholder="Flight Name"
					id="flight_name" name="flightName" /><br> <label
					for="no_of_passengers">Total Number of Passengers: </label> <input
					type="number" required="required" placeholder="No of Passengers"
					id="no_of_passengers" name="noOfPassengers" /><br> <label
					for="source">Select Source: </label> <select id="source"
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
				</select><br> <input type="submit" value="Add Flight" />
			</form>
		</div>
		<div>
			<h2 class="title">Flights in database</h2>
			<table border=2>
				<tr>
					<th>Flight Names</th>
					<th>Source</th>
					<th>Destination</th>
				</tr>

				<c:forEach var="flight" items="${flights}">
					<tr>
						<td>${flight.flightname}</td>
						<td>${flight.source.name}</td>
						<td>${flight.destination.name}</td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>
	<div class="dashboard-wrapper">
		<div>
			<h2 class="title">Allot Flight To Date</h2>
			<form action="AddDateOfFlight" method="post">
				<label for="flight">Select Flight: </label> <select id="flight"
					required="required" name="flight">
					<option value="">Select the flight</option>
					<c:forEach var="flight" items="${flights}">
						<option value="${flight.getFlightid()}">${flight.flightname}</option>
					</c:forEach>
				</select><br> <label for="data">Enter date: </label> <input type="date"
					required="required" placeholder="Date" id="date" name="flightDate" /><br>
				<input type="submit" value="Allot Flight" />
			</form>
		</div>
		<div>
			<h2 class="title">Flights Allocated</h2>
			<table border=2>
				<tr>
					<th>Flight Names</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Date</th>
				</tr>

				<c:forEach var="of" items="${ofs}">
					<tr>
						<td>${of.flight.flightname}</td>
						<td>${of.flight.source.name}</td>
						<td>${of.flight.destination.name}</td>
						<td>${of.date}</td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>
	<div class="dashboard-wrapper">
	<div>
			<h2 class="title">Get Passenger List</h2>
			<table border="2">
				<tr>
					<th>Passenger Name</th>
					<th>Passenger Age</th>
					<th>Flight Name</th>
					<th>Date of Booking</th>
				</tr>
				<c:forEach var="passenger" items="${passengers}">
					<tr>
						<td>${passenger.name}</td>
						<td>${passenger.age}</td>
						<td>${passenger.flight.flightname}</td>
						<td>${passenger.date}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
