package br.com.alexandre.cadastro.model;

import java.util.ArrayList;
import java.util.Iterator;

public class BancoEmpresas {
	
	private static ArrayList<Empresa> listaEmpresas = new ArrayList<>();
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer id = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		listaEmpresas.add(empresa1);
		empresa1.setNome("Philips");
		empresa1.setId(id++);
		Empresa empresa2 = new Empresa();
		listaEmpresas.add(empresa2);
		empresa2.setNome("LG");
		empresa2.setId(id++);
		Usuario usuario1 = new Usuario();
		listaUsuarios.add(usuario1);
		usuario1.setLogin("alexandre");
		usuario1.setSenha("12345");
		Usuario usuario2 = new Usuario();
		listaUsuarios.add(usuario2);
		usuario2.setLogin("vitor");
		usuario2.setSenha("123");
	}

	public ArrayList<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
	
	public void addEmpresa(Empresa empresa) {
		empresa.setId(id++);
		listaEmpresas.add(empresa);
	}
	
	public void excluirEmpresa(int id) {
		
		Iterator<Empresa> it = listaEmpresas.iterator();
		
		while(it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId() == id) {
				it.remove();
			}
		}
		
	}
	
	public Empresa exibirEmpresa(int id) {
		for(Empresa empresa: listaEmpresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
	
	public void alterarEmpresa(Empresa empresa, int id) {
		
		Iterator<Empresa> it = listaEmpresas.iterator();
		
		while(it.hasNext()) {
			Empresa empresa2 = it.next();
			
			if(empresa2.getId() == id) {
				empresa2.setNome(empresa.getNome());
				empresa2.setDataCriacao(empresa.getDataCriacao());
			}
		}
		
	}
	
	public Usuario verificarUsuario(String login, String senha) {
		Iterator<Usuario> it = listaUsuarios.iterator();
		
		while(it.hasNext()) {
			Usuario usuarioIterado = it.next();
			if(usuarioIterado.getLogin().equalsIgnoreCase(login) && usuarioIterado.getSenha().equalsIgnoreCase(senha)) {
				return usuarioIterado;
			}
		}
		return null;
	}
	
}
