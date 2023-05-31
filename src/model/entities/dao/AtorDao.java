package model.entities.dao;

import java.sql.SQLException;
import java.util.List;

import model.entities.Ator;
import model.entities.Pais;

public interface AtorDao {
	
	void insert(Ator obj) throws SQLException;
	void update(Ator obj);
	void delete(Ator obj);
	List<Ator> findAll();
	Ator findById(Integer id);
	List<Pais> findPais() throws SQLException;

}
