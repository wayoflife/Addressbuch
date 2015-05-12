<%@page import="de.dhbw.web.Address"%>
<%@page import="java.util.List"%>
<%@page import="de.dhbw.web.AddressList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Listenansicht</title>
	<jsp:useBean id="addressListKlasse" class="de.dhbw.web.AddressList" scope="page"/>
	<jsp:setProperty name="addressListKlasse" property="suchtext" param="suche"/>
</head>
<body>

<jsp:include page="Header.jsp" />

<h2>Unser supergeiles Addressbuch, yay</h2>

<%
	List<Address> list = addressListKlasse.getAddressListe();
	pageContext.setAttribute("adressen", list);
%>

<form method="GET">
	<label for="suche">Suche nach:</label>
	<input type="search" name="suche"/>
</form>
<form action="List.jsp">
	<input type="submit" value="Suche zurücksetzen"/>
</form>
<br>
<c:choose>
	<c:when test="${!empty adressen}">
	<table>
		<tr>
			<th>Vorname</th>
			<th>Nachname</th>
			<th>E-Mail-Adresse</th>
		</tr>
	<c:forEach items="${adressen}" var="ad">
		<tr>
			<td><c:out value="${ad.vorname}"></c:out></td>
			<td><c:out value="${ad.name}"></c:out></td>
			<td><c:out value="${ad.email}"></c:out></td>
			<td>
				<form action="Detail.jsp" method="GET">
					<button type="submit" name="id" value="${ad.id}">Detailansicht</button>
				</form>
			</td>
			<c:choose>
				<c:when test="${pageContext.request.isUserInRole('admin') || pageContext.request.isUserInRole('admin7')}">
					<td>
						<form action="Delete" method="POST">
							<button type="submit" name="id" value="${ad.id}">Löschen</button>
						</form>
					</td>
				</c:when>
			</c:choose>
		</tr>
	</c:forEach>
	</table>
	</c:when>
	<c:otherwise>
	Es konnten leider keine Ergebnisse gefunden werden!
	</c:otherwise>
</c:choose>

<br>

<c:choose>
	<c:when test="${pageContext.request.isUserInRole('admin') || pageContext.request.isUserInRole('admin7')}">
		<form action="Form.jsp">
			<input type="submit" value="Adresse hinzufügen">
		</form>
	</c:when>
</c:choose>

</body>
</html>