<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<h2>Willkommen beim Adressbuch!</h2>

Loggen Sie sich bitte hier ein oder betrachten Sie das Adressbuch als Gast.

<br>

<form action="j_security_check" method="POST">
	Benutzername: <input type="text" name="j_username">
	Passwort: <input type="password" name="j_password">
	<input type="submit" value="Login">
</form>

</body>
</html>