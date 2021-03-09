package br.com.alexandre.cadastro.model;

import java.util.Date;

public class Empresa {
	
	private String nome;
	private Date dataCriacao = new Date();
	private Integer id;

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
