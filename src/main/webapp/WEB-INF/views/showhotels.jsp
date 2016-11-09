<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>HOTEL BOOKING SYSTEM</title>
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
	<c:url var="addAction" value="/search"></c:url>
	<form:form action="${addAction}" commandName="selectCity">
		<h3>Cities List</h3>
		<c:if test="${!empty listCities}">
			<select name="id" id="id">
				<c:forEach items="${listCities}" var="city">
					<option value="${city.id}" id="cityname">${city.cityname}
					</option>
				</c:forEach>
			</select>
		</c:if>
		<input type="submit" class="search" value="<spring:message text="Search"/>" />
	</form:form>

	<h3>Hotels List</h3>
	<c:if test="${!empty listHotels}">
		<table class="tg">
			<tr>
				<th width="80"><b>HotelName</b></th>
				<th width="120"><b>Price</b></th>
			</tr>
			<c:forEach items="${listHotels}" var="hotel">
				<tr>
					<td>${hotel.hotelname}</td>
					<td>${hotel.price}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</c:if>
	<form:form>
		<input type="submit" class="submit" value="Cancel" onclick="form.action='index.jsp'">
	</form:form>

</body>
</html>