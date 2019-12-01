package br.com.cinema.model;

import java.sql.Time;
import java.util.Date;

public class Filme {
	
	int id;
	
	String titulo;
	int duracao;
	
	Date dataLancamento;
	
	
	StatusFilme status;
	
	public StatusFilme getStatus() {
		return status;
	}
	public void setStatus(StatusFilme status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
