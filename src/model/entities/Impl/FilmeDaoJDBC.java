package model.entities.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.entities.Filme;
import model.entities.dao.FilmeDao;

public class FilmeDaoJDBC implements FilmeDao {

	private Connection conn;

	public FilmeDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Filme insert(Filme obj) throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO filme (titulo,genero,sinopse,duracao) "
					+ "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getTitulo());
			st.setString(2, obj.getGenero());
			st.setString(3, obj.getSinopse());
			st.setInt(4, obj.getDuracao());
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setCodFilme(id);
				}
				rs.close();
			} else {
				System.out.println("Erro, nenhuma linha foi inserida");
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
		}
		return obj;
	}

	@Override
	public void update(Filme obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Filme> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filme findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
