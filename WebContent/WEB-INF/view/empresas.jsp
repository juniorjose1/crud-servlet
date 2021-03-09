<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro de Empresas</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"></c:import>
		
		<h3>Empresas Cadastradas: </h3>
		
		<ul>
			<c:forEach items="${listaEmpresas}" var="empresaIterada">
			<fmt:formatDate value="${empresaIterada.dataCriacao}" pattern="dd/MM/yyyy" var="dataFormatada" />
				
				<li>${empresaIterada.nome} - ${dataFormatada} | <a href="entrada?acao=EditarEmpresa&id=${empresaIterada.id}&exibir=s">Editar |</a> <a href="entrada?acao=ExcluirEmpresa&id=${empresaIterada.id}"> Remover</a></li>
						
			</c:forEach>
		</ul>
		
		<a href="entrada?acao=NovaEmpresaForm"><input type="button" value="Cadastrar Empresa"/></a>
	</body>
</html>