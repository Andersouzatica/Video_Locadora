package model.entities.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.entities.Filme;

public interface FilmeDao {

	public static final Connection conn = null;

	Filme insert(Filme obj) throws SQLException;

	void update(Filme obj);

	void deleteById(Integer id);

	List<Filme> findAll();

	Filme findById(Integer id);

}
