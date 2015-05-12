<%@page import="de.dhbw.web.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Detailansicht</title>
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

<form action="List.jsp">
	<input type="submit" value="Zurück zum Adressbuch">
</form>

<c:choose>
	<c:when test="${geladen}">
	<table>
		<tr>
			<td>Anrede</td>
			<td>
				<c:out value="${ad.addressform}"></c:out>
			</td>
		</tr>
		<tr>
			<td>Vorname</td>
			<td>
				<c:out value="${ad.vorname}"></c:out>
			</td>
		</tr>
		<tr>
			<td>Nachname</td>
			<td>
				<c:out value="${ad.name}"></c:out>
			</td>
		</tr>
		<tr>
			<td>E-Mail-Adresse</td>
			<td>
				<c:out value="${ad.email}"></c:out>
			</td>
		</tr>
		<tr>
			<td>Straße</td>
			<td>
				<c:out value="${ad.street}"></c:out>
			</td>
		</tr>
		<tr>
			<td>Hausnummer</td>
			<td>
				<c:out value="${ad.number}"></c:out>
			</td>
		</tr>
		<tr>
			<td>Postleitzahl</td>
			<td>
				<c:out value="${ad.postcode}"></c:out>
			</td>
		</tr>
		<tr>
			<td>Ort</td>
			<td>
				<c:out value="${ad.city}"></c:out>
			</td>
		</tr>
		<tr>
			<td>Land</td>
			<td>
				<c:out value="${ad.country}"></c:out>
			</td>
		</tr>
		<tr>
			<td>Festnetz</td>
			<td>
				<c:out value="${ad.phone}"></c:out>
			</td>
		</tr>
		<tr>
			<td>Handy</td>
			<td>
				<c:out value="${ad.mobile}"></c:out>
			</td>
		</tr>
		<tr>
			<td>Geburtstag</td>
			<td>
				<c:out value="${ad.birthday}"></c:out>
			</td>
		</tr>
	</table>
	
	<c:choose>
		<c:when test="${pageContext.request.isUserInRole('admin') || pageContext.request.isUserInRole('admin7')}">
			<form action="Form.jsp" method="GET">
				<button type="submit" name="id" value="${ad.id}">Bearbeiten</button>
			</form>
			<form action="Delete" method="POST">
				<button type="submit" name="id" value="${ad.id}">Löschen</button>
			</form>
		</c:when>
	</c:choose>
				
	</c:when>
	<c:otherwise>
		Leider ist das Laden der Adresse fehlgeschlagen!
	</c:otherwise>
</c:choose>

<!-- <a href="/Adressbuch/Delete">hier klicken, kein parameter</a><br>

<form name="deleteidget" action="Delete" method="get">
    <input type="text" name="id" value="123"/>
    <input type="submit" value="delete id get"/>
</form>

<form name="deleteidpost" action="Delete" method="post">
    <input type="text" name="id" value="123"/>
    <input type="submit" value="delete id post"/>
</form> -->

</body>
</html>