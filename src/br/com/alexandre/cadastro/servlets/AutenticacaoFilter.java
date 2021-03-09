package br.com.alexandre.cadastro.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Mapeamento feito pelo arquivo web.xml
 */
//@WebFilter("/autenticacao")
public class AutenticacaoFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
    
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AutenticacaoFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession session = request.getSession();
		String acao = request.getParameter("acao");
		Boolean usuarioNaoLogado = session.getAttribute("usuarioLogado") == null;
		Boolean paginasNaoProtegidas = acao.equalsIgnoreCase("LoginForm") || acao.equalsIgnoreCase("Login");
		
		if(usuarioNaoLogado && !paginasNaoProtegidas) {
			response.sendRedirect("entrada?acao=LoginForm");
			return ;
		}
		
		chain.doFilter(request, response);
		
	}

}
