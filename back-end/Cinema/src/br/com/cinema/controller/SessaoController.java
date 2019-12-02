package br.com.cinema.controller;

import br.com.cinema.model.Sessao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("Sessao")
public class SessaoController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public List<Object> listaSessaoFilme(@PathParam("id") int idFilme){
		try {
			List<Object> lista = new ArrayList();
			Sessao sessao = new Sessao();
			lista = sessao.ListarFilmeSessao(idFilme);
			return (List<Object>) lista;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
