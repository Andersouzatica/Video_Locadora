package model.entities.dao;

import model.entities.Impl.AtorDaoJDBC;
import model.entities.Impl.Filme2DaoJDBC;
import model.entities.Impl.FilmeDaoJDBC;
import model.entities.Impl.GeneroDaoJDBC;

public class DaoFactory {

	public static FilmeDao createFilmeDao() {
		return new FilmeDaoJDBC(model.entities.dao.ConexaoDB.getConexao());
	}

	public static Filme2Dao createFilmeDao2() {
		return new Filme2DaoJDBC(model.entities.dao.ConexaoDB.getConexao());
	}
	
	public static GeneroDao createGenero() {
		return new GeneroDaoJDBC(model.entities.dao.ConexaoDB.getConexao());
	}
	
	public static AtorDao createAtor() {
		return new AtorDaoJDBC(model.entities.dao.ConexaoDB.getConexao());
	}
	
}
