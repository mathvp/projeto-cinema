package br.com.cinema.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cinema.model.Filme;
import br.com.cinema.model.StatusFilme;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO implements BasicDAO {
	
	@Override
	public boolean salvar(Object filme) {
		// TODO Auto-generated method stub
		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "INSERT INTO filmes (titulo,duracao,status,dataLancamento,sinopse) VALUES (?,?,?,'2019-12-01',?)";
			PreparedStatement stmt = conn.prepareStatement(sql);			
			stmt.setString(1, ((Filme) filme).getTitulo());
			stmt.setInt(2, ((Filme) filme).getDuracao());
			stmt.setInt(3, ((Filme) filme).getStatus().getValue());
			//stmt.setDate(4, (Date) filme.getDataLancamento());
			stmt.setString(5, ((Filme) filme).getSinopse());
			
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean deletar(int idFilme) {
		// TODO Auto-generated method stub
		try {
			Connection conn = new ConnectionFactory().getConnection();
			String sql = "DELETE FROM filmes where id = (?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idFilme);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		try {
			List<Filme> listaFilmes = new ArrayList();
			Connection conn = new ConnectionFactory().getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM filmes";
			ResultSet result = stmt.executeQuery(sql);
			
			while(result.next()) {
				Filme objFilme = new Filme();
				objFilme.setId(result.getInt("id"));
				objFilme.setTitulo(result.getString("titulo"));
				objFilme.setDuracao(result.getInt("duracao"));
				objFilme.setStatus(StatusFilme.values()[result.getInt("status")]);
				objFilme.setImagem(result.getString("imagem"));
				objFilme.setSinopse(result.getString("sinopse"));
				//objFilme.setDataLancamento(resu);
				listaFilmes.add(objFilme);
			}
			conn.close();
			
			return (List<Object>)(Object)listaFilmes;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public Object getFilmeById(int idFilme) {
		// TODO Auto-generated method stub
		try {
			Connection conn = new ConnectionFactory().getConnection();
			Statement stmt = conn.createStatement();
			String sql = "Select * from filmes where id =" + idFilme;
			ResultSet result = stmt.executeQuery(sql);
			Filme objFilme = new Filme();
			while(result.next()) {
				objFilme.setId(result.getInt("id"));
				objFilme.setTitulo(result.getString("titulo"));
				objFilme.setDuracao(result.getInt("duracao"));
				objFilme.setStatus(StatusFilme.values()[result.getInt("status")]);
				objFilme.setImagem(result.getString("imagem"));
				//objFilme.setDataLancamento(result.getDate("dataLancamento"));
			}
			
			conn.close();
			
			return objFilme;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
