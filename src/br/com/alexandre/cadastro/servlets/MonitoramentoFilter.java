package br.com.alexandre.cadastro.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Mapeamento feito pelo arquivo web.xml
 */
//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		
		Long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		chain.doFilter(request, response);
		
		Long depois = System.currentTimeMillis();
		
		Long tempoExecucao = depois - antes;
		
		System.out.println("Tempo de execução da ação: " + acao + " -> " + tempoExecucao);
	}

}
