package br.com.cinema.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cinema.DAO.FilmeDAO;
import br.com.cinema.DAO.SessaoDAO;

public class Sessao implements ISessao {
	
	
	int id;
	Date horaSessao;
	double valorInteira;
	double valorMeia;
	Date encerramento;
	int idFilme;
	int idSala;
	
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public Date getHoraSessao() {
		return horaSessao;
	}
	public void setHoraSessao(Date horaSessao) {
		this.horaSessao = horaSessao;
	}
	public Date getEncerramento() {
		return encerramento;
	}
	public double getValorInteira() {
		return valorInteira;
	}
	public void setValorInteira(double valorInteira) {
		this.valorInteira = valorInteira;
	}
	public double getValorMeia() {
		return valorMeia;
	}
	public void setValorMeia(double valorMeia) {
		this.valorMeia = valorMeia;
	}
	public void setEncerramento(Date encerramento) {
		this.encerramento = encerramento;
	}
	public int getIdFilme() {
		return idFilme;
	}
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public List<Object> ListarFilmeSessao(int idFilme) {
		List<Object> lista = new ArrayList();
		SessaoDAO sdao = new SessaoDAO();
		lista = sdao.listaSessaobyFilme(idFilme);
		if(lista != null) {
			return  lista;
		}
		return null;
	}
	

}
