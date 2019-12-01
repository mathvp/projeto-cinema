package br.com.cinema.model;

import java.sql.Time;
import java.util.Date;
public class Filme {
	
	int id;
	String titulo;
	Time duracao;
	Date dataLancamento;
	
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
	public Time getDuracao() {
		return duracao;
	}
	public void setDuracao(Time time) {
		this.duracao = time;
	}
	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}
