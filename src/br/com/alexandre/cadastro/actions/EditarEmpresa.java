package br.com.alexandre.cadastro.actions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.cadastro.model.BancoEmpresas;
import br.com.alexandre.cadastro.model.Empresa;

public class EditarEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String exibe = request.getParameter("exibir");
		
		if(exibe != null) {
			
			String id = request.getParameter("id");
			Integer idConvertido = Integer.parseInt(id);
			
			BancoEmpresas banco = new BancoEmpresas();
			
			Empresa empresaSelecionada = banco.exibirEmpresa(idConvertido);
			
			String nomeEmpresa = empresaSelecionada.getNome();
			
			Date dataEmpresa = empresaSelecionada.getDataCriacao();
			
			request.setAttribute("nomeEmpresaAtual", nomeEmpresa);
			request.setAttribute("dataEmpresaAtual", dataEmpresa);
			request.setAttribute("idEmpresaAtual", idConvertido);
			
			return "request:WEB-INF/view/formEditarEmpresa.jsp";
			
		} else {
			return editar(request, response);
		}
		
		
	}
	
	public String editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		
		String nomeEmpresa = request.getParameter("nomeEmpresa");
		String dataEmpresa = request.getParameter("dataEmpresa");
		String idEmpresa = request.getParameter("idEmpresa");
		
		Integer idConvertido = Integer.parseInt(idEmpresa);
		
		Empresa empresa = new Empresa();
		BancoEmpresas bancoEmpresas = new BancoEmpresas();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataEmpresaConvertida = null;
		try {
			dataEmpresaConvertida = sdf.parse(dataEmpresa);
		} catch (ParseException | NullPointerException e) {
			throw new ServletException(e);
		}
		
		empresa.setNome(nomeEmpresa);
		empresa.setDataCriacao(dataEmpresaConvertida);
		
		bancoEmpresas.alterarEmpresa(empresa, idConvertido);
		
		return "response:entrada?acao=ListaEmpresas";
		
	}

}
