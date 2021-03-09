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

public class AdicionaEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Empresa empresa = new Empresa();
		
		BancoEmpresas banco = new BancoEmpresas();
		
		String nomeEmpresa = request.getParameter("nomeEmpresa");
		
		String dataCriacao = request.getParameter("dataEmpresa");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataCriacaoConvertida = null;
		
		try {
			dataCriacaoConvertida = sdf.parse(dataCriacao);
		} catch (ParseException | NullPointerException e) {
			throw new ServletException(e);
		}
		
		empresa.setNome(nomeEmpresa);
		
		empresa.setDataCriacao(dataCriacaoConvertida);
		
		banco.addEmpresa(empresa);
		
		return "response:entrada?acao=ListaEmpresas";
	}

}
