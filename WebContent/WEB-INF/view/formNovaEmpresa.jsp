<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Adicionar Empresa</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"></c:import>
		
		<h3>Cadastrar Empresa</h3>
		
			<form action="entrada?acao=AdicionaEmpresa" method="post">
					
				Nome: <input type="text" name="nomeEmpresa" /><br><br>
				Data da Criação: <input type="text" name="dataEmpresa"/>
				<br><br>
				<input type="submit" value="Cadastrar"/>
							
			</form>
	</body>
</html>