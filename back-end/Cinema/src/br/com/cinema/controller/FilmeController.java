package br.com.cinema.controller;

import br.com.cinema.model.Filme;
import br.com.cinema.DAO.*;

import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Filmes")
public class FilmeController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object> index(){
		Filme objFilme = new Filme();
		return	objFilme.ListarFilmes();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean cadastrar(Filme filme) {
		Filme modelo = new Filme();
		
		return modelo.cadastrarFilme(filme);
		
	}
	
	
	@DELETE
	@Path("/{id}")
	public boolean delete(@PathParam("id") int idFilme) {
		
		Filme filme = new Filme();
		
		return filme.deletarFilme(idFilme);
		
	}
	
}
