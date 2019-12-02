package br.com.cinema.model;

import java.util.List;

public interface IFilme {
	
	public boolean cadastrarFilme(Filme filme);
	
	public boolean deletarFilme(int idFilme);
	
	public List<Object> ListarFilmes();
}
