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
<%-- <jsp:setProperty name="addressListKlasse" property="*"/> --%>
</head>
<body>

<h1>Unser supergeiles Addressbuch, yay</h1>

<%
	List<Address> list = addressListKlasse.getAddressListe();
	pageContext.setAttribute("adressen", list);
%>

<table>
	<tr>
		<th>Vorname</th>
		<th>Nachname</th>
		<th>E-Mail-Adresse</th>
	</tr>
<c:forEach items="${adressen}" var="ad">
	<tr>
	<td>${ad.vorname}</td><td>${ad.name}</td><td>${ad.email}</td>
	</tr>
</c:forEach>
</table>

</body>
</html>