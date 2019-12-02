package br.com.cinema.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.cinema.model.Filme;
import br.com.cinema.model.Sessao;
import br.com.cinema.model.StatusFilme;

public class SessaoDAO implements BasicDAO {

	@Override
	public boolean salvar(Object bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> listaSessaobyFilme(int idFilme) {
		try {
			List<Sessao> listaSessao = new ArrayList();
			Connection conn = new ConnectionFactory().getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM Sessao WHERE Filmes_id =" + idFilme;
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				Sessao objSessao = new Sessao();
				 objSessao.setId(result.getInt("id"));
				objSessao.setHoraSessao(result.getDate("horaSessao"));
				objSessao.setValorInteira(result.getDouble("valorInteiro"));
				objSessao.setValorMeia(result.getDouble("valorMeia"));
				objSessao.setIdSala(result.getInt("Sala_id"));
				objSessao.setIdFilme(result.getInt("Filmes_id"));
				objSessao.setEncerramento(result.getDate("encerramento"));
				listaSessao.add(objSessao);
			}

			conn.close();

			return (List<Object>) (Object) listaSessao;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
