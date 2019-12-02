package br.com.cinema.DAO;

import java.util.List;

public interface BasicDAO {
	
	public boolean salvar (Object bean);
	public boolean deletar(int id);
	public List<Object> getAll();
}
