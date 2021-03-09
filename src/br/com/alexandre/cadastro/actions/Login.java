package br.com.alexandre.cadastro.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alexandre.cadastro.model.BancoEmpresas;
import br.com.alexandre.cadastro.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		BancoEmpresas banco = new BancoEmpresas();
		Usuario usuarioAutenticado = banco.verificarUsuario(login, senha);
		
		if(usuarioAutenticado != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuarioAutenticado);
			request.setAttribute("login", usuarioAutenticado.getLogin());
			return "response:entrada?acao=ListaEmpresas";
		} else {
			return "request:WEB-INF/view/loginForm.jsp";
		}
		
	}

}
