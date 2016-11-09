<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>CONFIRMATION PAGE</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h3></h3>
	<div>${errorMessage}</div>
	<div>${errorMessages}</div>
	<c:if test="${!empty bookedinfo}">
		<table>
			<tr>
				<td><b>Generate Booking Reference Number</b></td>
				<td>${bookedinfo.refno}</td>
			</tr>
			<tr>
				<td><b>City</b></td>
				<td>${bookedinfo.city}</td>
			</tr>
			<tr>
				<td><b>Hotel</b></td>
				<td>${bookedinfo.hotel}</td>
			</tr>
			<tr>
				<td><b>CheckInDate</b></td>
				<td>${bookedinfo.checkindate}</td>
			</tr>
			<tr>
				<td><b>CheckOutDate</b></td>
				<td>${bookedinfo.checkoutdate}</td>
			</tr>
			<tr>
				<td><b>NumberOfRooms</b></td>
				<td>${bookedinfo.numberofrooms}</td>
			</tr>
			<c:if test="${!empty priceamount}">
				<tr>
					<td><b>Price/Day for a Room</b></td>
					<td>${priceamount}</td>
				</tr>
			</c:if>
			<tr>
					<td><b>Total amount payable by the customer for this booking:</b></td>
					<td>${totalamount}</td>
				</tr>
		</table>
		<br>
	</c:if>
	<form:form>
		<input type="submit" value="Cancel" onclick="form.action='index.jsp'">
	</form:form>
</body>
</html>