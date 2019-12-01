package br.com.cinema.resource;

import br.com.cinema.model.Filme;
import br.com.cinema.DAO.*;

import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Filmes")
public class FilmeResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Filme> index(){
		List<Filme> lista = new ArrayList();
		try {
			FilmeDAO fdao = new FilmeDAO();
			lista = fdao.BuscaFilmes();
			return lista;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean cadastrar(Filme filme) {
		try {
			FilmeDAO fdao = new FilmeDAO();
			fdao.CadastrarFilme(filme);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
