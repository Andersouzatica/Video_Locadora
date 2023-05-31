package model.entities.dao;

import java.sql.SQLException;
import java.util.List;

import model.entities.Filme2;

public interface Filme2Dao {


	List<Filme2> findAll() throws SQLException;
	void inserir(Filme2 obj) throws SQLException;
	void update(Filme2 obj) throws SQLException;
	void deleteById (Filme2 obj) throws SQLException;
	Filme2 findById (Integer id) throws SQLException;

	

}
