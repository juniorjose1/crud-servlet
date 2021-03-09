package br.com.alexandre.cadastro.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.cadastro.actions.Acao;

/**
 * Mapeamento feito pelo arquivo web.xml
 */
//@WebFilter("/entrada")
public class EntradaFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
 
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("EntradaFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String param = request.getParameter("acao");
		String caminho = null;
		String classe = "br.com.alexandre.cadastro.actions." + param;
				
		try {
			Class<?> classeInstanciada = Class.forName(classe);
			Acao acao = (Acao) classeInstanciada.newInstance();
			caminho = acao.executa(request, response);
		} catch(ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			e.getStackTrace();
		}
		
		String[] caminhoFormado = caminho.split(":");
		
		if(caminhoFormado[0].equals("request")) {
			RequestDispatcher rd = request.getRequestDispatcher(caminhoFormado[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(caminhoFormado[1]);
		}
		
	}

}
