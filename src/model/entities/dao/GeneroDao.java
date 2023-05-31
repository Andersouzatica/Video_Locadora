package model.entities.dao;

import java.sql.SQLException;
import java.util.List;

import model.entities.Genero;

public interface GeneroDao {
	
	void inserir(Genero obj) throws SQLException;
	void update(Genero obj) throws SQLException;
	void deleteById(Genero obj) throws SQLException;
	List<Genero> listagenero() throws SQLException;
	Genero findById(Integer id) throws SQLException;
	

}
