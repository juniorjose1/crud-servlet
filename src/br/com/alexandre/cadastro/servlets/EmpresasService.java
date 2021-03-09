package br.com.alexandre.cadastro.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alexandre.cadastro.model.BancoEmpresas;
import br.com.alexandre.cadastro.model.Empresa;


@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BancoEmpresas banco = new BancoEmpresas();
		ArrayList<Empresa> listaEmpresas = banco.getListaEmpresas();
		String header = request.getHeader("Accept");
		PrintWriter printWriter = response.getWriter();
		
		if(header.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("Empresa", Empresa.class);
			String empresasXml = xstream.toXML(listaEmpresas);
			
			response.setContentType("application/xml");
			printWriter.print(empresasXml);
		} else if(header.contains("json")) {
			Gson gson = new Gson();
			String empresasJson = gson.toJson(listaEmpresas);
			
			response.setContentType("application/json");
			printWriter.print(empresasJson);
		} else {
			response.setContentType("application/xml");
			printWriter.print("'Message: no content'");
		}
		
	}

}
