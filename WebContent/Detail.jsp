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
				${ad.addressform}
			</td>
		</tr>
		<tr>
			<td>Vorname</td>
			<td>
				${ad.vorname}
			</td>
		</tr>
		<tr>
			<td>Nachname</td>
			<td>
				${ad.name}
			</td>
		</tr>
		<tr>
			<td>E-Mail-Adresse</td>
			<td>
				${ad.email}
			</td>
		</tr>
		<tr>
			<td>Straße</td>
			<td>
				${ad.street}
			</td>
		</tr>
		<tr>
			<td>Hausnummer</td>
			<td>
				${ad.number}
			</td>
		</tr>
		<tr>
			<td>Postleitzahl</td>
			<td>
				${ad.postcode}
			</td>
		</tr>
		<tr>
			<td>Ort</td>
			<td>
				${ad.city}
			</td>
		</tr>
		<tr>
			<td>Land</td>
			<td>
				${ad.country}
			</td>
		</tr>
		<tr>
			<td>Festnetz</td>
			<td>
				${ad.phone}
			</td>
		</tr>
		<tr>
			<td>Handy</td>
			<td>
				${ad.mobile}
			</td>
		</tr>
		<tr>
			<td>Geburtstag</td>
			<td>
				${ad.birthday}
			</td>
		</tr>
	</table>
	
	<form action="Form.jsp" method="GET">
		<button type="submit" name="id" value="${ad.id}">Bearbeiten</button>
	</form>
	<form action="Delete" method="POST">
		<button type="submit" name="id" value="${ad.id}">Löschen</button>
	</form>
				
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