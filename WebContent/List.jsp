<%@page import="de.dhbw.web.AddressList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listenansicht</title>
</head>
<body>

<h1>Unser supergeiles Addressbuch, yay</h1>

<jsp:useBean id="addressList" class="de.dhbw.web.AddressList"></jsp:useBean>
<jsp:getProperty property="AddressListe" name="addressList"/>
<%
	AddressList list = new AddressList();
	pageContext.setAttribute("addressliste", list);
%>

<table>
<c:forEach var="ad" items="${addressliste.AddressListe}">
	<tr>
	<td>${ad.name}</td><td>${ad.vorname}</td><td>${ad.email}</td>
	</tr>
</c:forEach>
</table>

</body>
</html>