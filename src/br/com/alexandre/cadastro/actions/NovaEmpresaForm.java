package br.com.alexandre.cadastro.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "request:WEB-INF/view/formNovaEmpresa.jsp";
	}

}
