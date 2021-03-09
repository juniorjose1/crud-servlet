<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Editar Empresa</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"></c:import>
		<h3>Editar Empresa</h3>
			<form action="entrada?acao=EditarEmpresa" method="post">
				<fmt:formatDate value="${dataEmpresaAtual}" pattern="dd/MM/yyyy" var="dataFormatada"/>
				
				<input type="text" name="nomeEmpresa" value="${nomeEmpresaAtual}"/>
				<br><br>
				<input type="text" name="dataEmpresa" value="${dataFormatada}"/>
				<br><br>
				<input type="submit" value="Editar" />
					
				<input type="hidden" name="idEmpresa" value="${idEmpresaAtual}"/>
							
			</form>
	</body>
</html>