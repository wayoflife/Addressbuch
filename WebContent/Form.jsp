<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Eingabeformular</title>
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

<form method="POST" action="Save">
	<table>
		<tr>
			<td>Anrede</td>
			<td>
				<input type="text" name="addressform"/>
			</td>
		</tr>
		<tr>
			<td>Vorname</td>
			<td>
				<input type="text" name="vorname"/>
			</td>
		</tr>
		<tr>
			<td>Nachname</td>
			<td>
				<input type="text" name="name"/>
			</td>
		</tr>
		<tr>
			<td>E-Mail-Adresse</td>
			<td>
				<input type="text" name="email"/>
			</td>
		</tr>
		<tr>
			<td>Straße</td>
			<td>
				<input type="text" name="street"/>
			</td>
			<td>Hausnummer</td>
			<td>
				<input type="text" name=number/>
			</td>
		</tr>
		<tr>
			<td>Postleitzahl</td>
			<td>
				<input type="text" name="postcode"/>
			</td>
			<td>Ort</td>
			<td>
				<input type="text" name="city"/>
			</td>
		</tr>
		<tr>
			<td>Land</td>
			<td>
				<input type="text" name="country"/>
			</td>
		</tr>
		<tr>
			<td>Festnetz</td>
			<td>
				<input type="text" name="phone"/>
			</td>
		</tr>
		<tr>
			<td>Handy</td>
			<td>
				<input type="text" name="mobile"/>
			</td>
		</tr>
		<tr>
			<td>Geburtstag</td>
			<td>
				<input type="text" name="birthday"/>
			</td>
		</tr>
	</table>
	<input type="submit" value="Speichern">
</form>

</body>
</html>