package model.entities.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entities.Filme2;
import model.entities.Genero;
import model.entities.dao.Filme2Dao;

public class Filme2DaoJDBC implements Filme2Dao {

	private Connection conn;

	public Filme2DaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Filme2> findAll() throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("select f.codfilme, f.titulo, g.descricao, f.sinopse, f.duracao from "
					+ "filme2 as f join genero as g on (f.codgenero = g.codgenero) order by codfilme desc");
			ResultSet rs = st.executeQuery();
			List<Filme2> list = new ArrayList<>();
			while (rs.next()) {
				Genero genero = new Genero();
				genero.setDescricao(rs.getString("g.descricao"));
				Filme2 filme = new Filme2();
				filme.setCodFilme(rs.getInt("f.codfilme"));
				filme.setTitulo(rs.getString("f.titulo"));
				filme.setGenero(genero);
				filme.setSinopse(rs.getString("f.sinopse"));
				filme.setDuracao(rs.getInt("f.duracao"));
				list.add(filme);

			}
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
		}
		return null;
	}

	@Override
	public void inserir(Filme2 obj) throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO filme2 (titulo,codGenero,sinopse,duracao) " + "VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getTitulo());
			st.setInt(2, obj.getGenero().getCodGenero());
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
		}

	}

	@Override
	public void update(Filme2 obj) throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE filme2 SET titulo = ?, codgenero = ?, sinopse = ?, duracao = ? WHERE codFilme = ?");
			st.setString(1, obj.getTitulo());
			st.setInt(2, obj.getGenero().getCodGenero());
			st.setString(3, obj.getSinopse());
			st.setInt(4, obj.getDuracao());
			st.setInt(5, obj.getCodFilme());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
		}
	}

	@Override
	public Filme2 findById(Integer id) throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("SELECT * FROM filme2 WHERE codfilme = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				Genero genero = new Genero();
				genero.setCodGenero(rs.getInt("codgenero"));

				Filme2 filme2 = new Filme2();
				filme2.setCodFilme(rs.getInt("codfilme"));
				filme2.setTitulo(rs.getString("titulo"));
				filme2.setGenero(genero);
				filme2.setSinopse(rs.getString("sinopse"));
				filme2.setDuracao(rs.getInt("duracao"));
				return filme2;
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
		}
		return null;
	}

	@Override
	public void deleteById(Filme2 obj) throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM filme2 WHERE codfilme = ?");
			st.setInt(1, obj.getCodFilme());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
		}

	}
}
