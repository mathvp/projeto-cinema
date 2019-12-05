package br.com.cinema.model;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cinema.DAO.FilmeDAO;

public class Filme implements IFilme{
	
	int id;
	
	String titulo;
	int duracao;
	
	String imagem;
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	String sinopse;
	
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
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	@Override
	public boolean cadastrarFilme(Filme filme) {
		// TODO Auto-generated method stub
		try {
			FilmeDAO fdao = new FilmeDAO();
			fdao.salvar(filme);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deletarFilme(int idFilme) {
		// TODO Auto-generated method stub
		try {
			FilmeDAO fdao = new FilmeDAO();
			if(idFilme != 0) {
				fdao.deletar(idFilme);
				return true;
			}
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Object> ListarFilmes() {
		// TODO Auto-generated method stub
		List<Object> lista = new ArrayList();
		FilmeDAO fdao = new FilmeDAO();
		lista = fdao.getAll();
		if(lista != null) {
			return  (List<Object>) lista;
		}
		return null;
	}
	@Override
	public Object getFilmeById(int idFilme) {
		// TODO Auto-generated method stub
		FilmeDAO fdao = new FilmeDAO();
		return fdao.getFilmeById(idFilme);
	}
	
	

}
