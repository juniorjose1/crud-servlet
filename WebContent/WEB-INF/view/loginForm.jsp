<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="entrada" var="linkServlet"> </c:url>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
	
		<form action="${linkServlet}?acao=Login" method="post">
			Login: <input type="text" name="login"><br><br>
			Senha: <input type="password" name="senha"><br><br>
			<input type="submit" value="Entrar">
		</form>
	
	</body>
</html>