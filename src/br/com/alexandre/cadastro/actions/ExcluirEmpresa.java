package br.com.alexandre.cadastro.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.cadastro.model.BancoEmpresas;

public class ExcluirEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		int idConvertido = Integer.valueOf(id);
		
		BancoEmpresas bancoEmpresas = new BancoEmpresas();
		
		bancoEmpresas.excluirEmpresa(idConvertido);
		
		return "response:entrada?acao=ListaEmpresas";
		
	}

}
