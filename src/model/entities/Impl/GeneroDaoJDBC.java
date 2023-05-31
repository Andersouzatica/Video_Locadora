package model.entities.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.Genero;
import model.entities.dao.GeneroDao;

public class GeneroDaoJDBC implements GeneroDao {

	private Connection conn;

	public GeneroDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Genero> listagenero() throws SQLException {
		PreparedStatement st = null;

		try {
			List<Genero> generos = new ArrayList<>();
			st = conn.prepareStatement("SELECT * FROM genero");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Genero genero = new Genero();
				genero.setCodGenero(rs.getInt("codGenero"));
				genero.setDescricao(rs.getString("descricao"));
				generos.add(genero);

			}
			rs.close();
			return generos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
		}
		return null;
	}


	@Override
	public void inserir(Genero obj) throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO genero (descricao) VALUES (?)",Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getDescricao());
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setCodGenero(id);
				}
				rs.close();
			} else {
				System.out.println("Erro, nenhuma linha foi inserida");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
		}
		
	}


	@Override
	public void update(Genero obj) throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE genero SET descricao = ? WHERE codgenero = ?");
			st.setString(1, obj.getDescricao());
			st.setInt(2, obj.getCodGenero());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
		}
	
	}


	@Override
	public void deleteById(Genero obj) throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM genero WHERE codgenero = ?");
			st.setInt(1, obj.getCodGenero());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
		}
	}


	@Override
	public Genero findById(Integer id) throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("SELECT * FROM genero WHERE codgenero = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Genero genero = new Genero();
				genero.setCodGenero(rs.getInt("codgenero"));
				genero.setDescricao(rs.getString("descricao"));
				
				return genero;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
		}
		
		return null;
	}

}
