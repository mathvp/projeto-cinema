package br.com.cinema.controller;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cinema.DAO.*;

@Path("/")
public class HomeController {
	@GET
	public String index() throws SQLException {
		
		//FilmeDAO film = new FilmeDAO();
		
		return "Hello World!";
	}
	
	
	
}
