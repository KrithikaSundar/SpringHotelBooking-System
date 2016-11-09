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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script> -->

<script>
	$(function() {
		$("#checkindate").datepicker({
			numberOfMonths : 2,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate() + 1);
				$("#checkoutdate").datepicker("option", "minDate", dt);
			}
		});
		$("#checkoutdate").datepicker({
			numberOfMonths : 2,
			onSelect : function(selected) {
				var dt = new Date(selected);
				dt.setDate(dt.getDate() - 1);
				$("#checkindate").datepicker("option", "maxDate", dt);
			}
		});
		$("#city").change(function() {
			if ($(this).data('options') == undefined) {
				/*Taking an array of all options-2 and kind of embedding it on the select1*/
				$(this).data('options', $('#hotel option').clone());
			}
			var id = $(this).val();
			var options = $(this).data('options').filter('[value=' + id + ']');
			$('#hotel').html(options);
		});
	});
</script>
<script type="text/javascript">
	var specialKeys = new Array();
	specialKeys.push(8); //Backspace
	function IsNumeric(e) {
		var keyCode = e.which ? e.which : e.keyCode
		var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys
				.indexOf(keyCode) != -1);
		document.getElementById("error").style.display = ret ? "none"
				: "inline";
		return ret;
	}
	function isValidDate(date)
	{
	    var matches = /^(\d{1,2})[-\/](\d{1,2})[-\/](\d{4})$/.exec(date);
	    if (matches == null) return false;
	    var d = matches[2];
	    var m = matches[1] - 1;
	    var y = matches[3];
	    var composedDate = new Date(y, m, d);
	    document.getElementById("errors").style.display = matches ? "none"
				: "inline";
	    return composedDate.getDate() == d &&
	            composedDate.getMonth() == m &&
	            composedDate.getFullYear() == y;
	}
</script>
</head>
<body>

	<c:url var="addAction" value="/go"></c:url>
	<form:form action="${addAction}" commandName="selectCity">
		<table>
			<tr>
				<td style="width: 115px;">City</td>
				<td><c:if test="${!empty listCities}">
						<select name="id" id="id" >
							<c:forEach items="${listCities}" var="city">
								<option value="${city.id}" id="cityname">${city.cityname}
								</option>
							</c:forEach>
						</select>
					</c:if></td>
				<td>
						<input type="submit" class="submit"
							value="<spring:message text="Go"/>" />
					</td>
			</tr>
		</table>
	</form:form>



	<c:url var="addAction" value="/confirm"></c:url>

	<form:form action="${addAction}" commandName="bookedhotels" name="f2">
		<table>
			<%-- <tr>
			<td>City:</td>
			<td><c:if test="${!empty listCities}">
					<select name="city" id="city">
						<c:forEach items="${listCities}" var="city">
							<option value="${city.id}">${city.cityname}</option>
						</c:forEach>
					</select>
				</c:if></td>
		</tr> --%>
			<tr>
				<td>Hotel</td>
				<td><c:if test="${!empty listHotels}">
						<select name="hotel" id="hotel">
							<c:forEach items="${listHotels}" var="hotel">
								<option value="${hotel.hotelname}">${hotel.hotelname}</option>
							</c:forEach>
						</select>
					</c:if></td>
			</tr>
			<tr>
				<td>Check-in date:</td>
				<td><input type="text" name="checkindate" id="checkindate" onkeypress="return isValidDate(event);"
					required /></td>
			</tr>
			<tr>
				<td>Check-out date:</td>
				<td><input type="text" name="checkoutdate" id="checkoutdate" onkeypress="return isValidDate(event);"
					required /></td>
			</tr>
			<tr>
				<td>Number of Rooms</td>
				<td><input type="text" name="numberofrooms" id="numberofrooms"
					onkeypress="return IsNumeric(event);" ondrop="return false;"
					required /><span id="error" style="color: Red; display: none">*
						The value provided for the field NumberofRooms is incorrect or incomplete</span></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" class="submit"
					value="<spring:message text="Book Room"/>" /></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<td><form:form>
					<input type="submit" value="Cancel"
						onclick="form.action='index.jsp'">
				</form:form></td>
		</tr>
	</table>
</body>
</html>