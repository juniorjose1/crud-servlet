package br.com.alexandre.cadastro.actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.cadastro.model.BancoEmpresas;
import br.com.alexandre.cadastro.model.Empresa;

public class ListaEmpresas implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BancoEmpresas banco = new BancoEmpresas();
		ArrayList<Empresa> listaEmpresa = new ArrayList<>();
		
		listaEmpresa = banco.getListaEmpresas();
			
		System.out.println(listaEmpresa);
		
		request.setAttribute("listaEmpresas", listaEmpresa);
		
		return "request:WEB-INF/view/empresas.jsp";
			
	}

}
