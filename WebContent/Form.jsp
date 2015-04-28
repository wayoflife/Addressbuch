<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Eingabeformular</title>
	<jsp:useBean id="adresse" class="de.dhbw.web.Address" scope="page"/>
	<jsp:setProperty name="adresse" property="id" param="id"/>
</head>
<body>

<jsp:include page="Header.jsp" />

<h2>Eingabeformular</h2>

<%
	boolean erfolgreichGeladen = false;
	if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
		erfolgreichGeladen = adresse.read(Integer.parseInt(request.getParameter("id")));
		pageContext.setAttribute("ad", adresse);
	}
	pageContext.setAttribute("geladen", erfolgreichGeladen);
%>

<form method="POST" action="Save">
	<table>
		<tr>
			<td>Anrede</td>
			<td>
				<input type="text" name="addressform" value="${ad.addressform}"/>
			</td>
		</tr>
		<tr>
			<td>Vorname</td>
			<td>
				<input type="text" name="vorname" value="${ad.vorname}"/>
			</td>
		</tr>
		<tr>
			<td>Nachname</td>
			<td>
				<input type="text" name="name" value="${ad.name}"/>
			</td>
		</tr>
		<tr>
			<td>E-Mail-Adresse</td>
			<td>
				<input type="text" name="email" value="${ad.email}"/>
			</td>
		</tr>
		<tr>
			<td>Straße</td>
			<td>
				<input type="text" name="street" value="${ad.street}"/>
			</td>
			<td>Hausnummer</td>
			<td>
				<input type="text" name=number value="${ad.number}"/>
			</td>
		</tr>
		<tr>
			<td>Postleitzahl</td>
			<td>
				<input type="text" name="postcode" value="${ad.postcode}"/>
			</td>
			<td>Ort</td>
			<td>
				<input type="text" name="city" value="${ad.city}"/>
			</td>
		</tr>
		<tr>
			<td>Land</td>
			<td>
				<input type="text" name="country" value="${ad.country}"/>
			</td>
		</tr>
		<tr>
			<td>Festnetz</td>
			<td>
				<input type="text" name="phone" value="${ad.phone}"/>
			</td>
		</tr>
		<tr>
			<td>Handy</td>
			<td>
				<input type="text" name="mobile" value="${ad.mobile}"/>
			</td>
		</tr>
		<tr>
			<td>Geburtstag</td>
			<td>
				<input type="text" name="birthday" value="${ad.birthday}"/>
			</td>
		</tr>
	</table>
	<button type="submit" name="id" value="${ad.id}">Speichern</button>
</form>

<c:choose>
<c:when test="${not empty ad.id}">
<form action="Detail.jsp" method="GET">
	<button type="submit" name="id" value="${ad.id}">Abbrechen</button>
</form>
</c:when>
<c:otherwise>
<form action="List.jsp">
	<input type="submit" value="Abbrechen">
</form>
</c:otherwise>
</c:choose>

</body>
</html>