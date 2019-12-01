package br.com.cinema.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cinema.model.Filme;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
	
	public List<Filme> BuscaFilmes() throws SQLException{
		
		try {
			List<Filme> listaFilmes = new ArrayList();
			Connection conn = new ConnectionFactory().getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM filmes WHERE filmes where status == 1";
			ResultSet result = stmt.executeQuery(sql);
			
			while(result.next()) {
				Filme objFilme = new Filme();
				objFilme.setId(result.getInt("id"));
				objFilme.setTitulo(result.getString("titulo"));
				objFilme.setDuracao(result.getTime("duracao"));
				objFilme.setDataLancamento(result.getDate("dateLancamento"));
				listaFilmes.add(objFilme);
			}
			
			conn.close();
			
			return listaFilmes;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void CadastrarFilme(Filme filme) {
		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "INSERT INTO Filmes (titulo,duracao,dateLancamento) VALUES (?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, filme.getTitulo());
			stmt.setTime(2, filme.getDuracao());
			stmt.setDate(3, (Date) filme.getDataLancamento());
			
			stmt.execute();
				
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
