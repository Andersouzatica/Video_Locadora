package view;

import java.sql.SQLException;
import java.util.List;

import model.entities.Ator;
import model.entities.Pais;
import model.entities.Impl.AtorDaoJDBC;
import model.entities.dao.ConexaoDB;

public class TesteAtor {

	public static void main(String[] args) throws SQLException {

		AtorDaoJDBC atorDaoJDBC = new AtorDaoJDBC(ConexaoDB.getConexao());
		Pais pais = new  Pais(2, null);
		Ator ator = new Ator();
//		ator.setName("Recife");
//		ator.setPais(pais);
//		atorDaoJDBC.insert(ator);
		System.out.println(ator);
		
		
		List<Pais> list = atorDaoJDBC.findPais();
		for (Pais pais2 : list) {
			System.out.println(pais2);
		}
		
	}

}
