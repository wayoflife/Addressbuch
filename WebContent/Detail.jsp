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

<%
	boolean erfolgreichGeladen = false;
	if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
		erfolgreichGeladen = adresse.read(Integer.parseInt(request.getParameter("id")));
	}
	pageContext.setAttribute("geladen", erfolgreichGeladen);
%>

<c:choose>
	<c:when test="${geladen}">
	<table>
		<tr>
			<td>Anrede</td>
			<td>
				<jsp:getProperty name="adresse" property="addressform"/>
			</td>
		</tr>
		<tr>
			<td>Vorname</td>
			<td>
				<jsp:getProperty name="adresse" property="vorname"/>
			</td>
		</tr>
		<tr>
			<td>Nachname</td>
			<td>
				<jsp:getProperty name="adresse" property="name"/>
			</td>
		</tr>
		<tr>
			<td>E-Mail-Adresse</td>
			<td>
				<jsp:getProperty name="adresse" property="email"/>
			</td>
		</tr>
		<tr>
			<td>Straße</td>
			<td>
				<jsp:getProperty name="adresse" property="street"/>
			</td>
		</tr>
		<tr>
			<td>Hausnummer</td>
			<td>
				<jsp:getProperty name="adresse" property="number"/>
			</td>
		</tr>
		<tr>
			<td>Postleitzahl</td>
			<td>
				<jsp:getProperty name="adresse" property="postcode"/>
			</td>
		</tr>
		<tr>
			<td>Ort</td>
			<td>
				<jsp:getProperty name="adresse" property="city"/>
			</td>
		</tr>
		<tr>
			<td>Land</td>
			<td>
				<jsp:getProperty name="adresse" property="country"/>
			</td>
		</tr>
		<tr>
			<td>Festnetz</td>
			<td>
				<jsp:getProperty name="adresse" property="phone"/>
			</td>
		</tr>
		<tr>
			<td>Handy</td>
			<td>
				<jsp:getProperty name="adresse" property="mobile"/>
			</td>
		</tr>
		<tr>
			<td>Geburtstag</td>
			<td>
				<jsp:getProperty name="adresse" property="birthday"/>
			</td>
		</tr>
	</table>
	</c:when>
	<c:otherwise>
		<c:redirect url="/List.jsp"/>
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