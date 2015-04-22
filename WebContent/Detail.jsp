<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detailansicht</title>
</head>
<body>

<a href="/Adressbuch/Delete">hier klicken, kein parameter</a><br>

<form name="deleteidget" action="Delete" method="get">
    <input type="text" name="id" value="123"/>
    <input type="submit" value="delete id get"/>
</form>

<form name="deleteidpost" action="Delete" method="post">
    <input type="text" name="id" value="123"/>
    <input type="submit" value="delete id post"/>
</form>

</body>
</html>