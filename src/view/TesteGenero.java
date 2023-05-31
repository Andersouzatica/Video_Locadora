package view;

import java.sql.SQLException;
import java.util.List;

import model.entities.Genero;
import model.entities.Impl.GeneroDaoJDBC;
import model.entities.dao.ConexaoDB;

public class TesteGenero {

	public static void main(String[] args) throws SQLException {

		GeneroDaoJDBC generoDaoJDBC = new GeneroDaoJDBC(ConexaoDB.getConexao());

		System.out.println("Inserir");
		Genero genero = new Genero();
//		genero.setDescricao("Esporte");
//		generoDaoJDBC.inserir(genero);
		System.out.println(genero);

		System.out.println("Atualizar");
		Genero genero2 = generoDaoJDBC.findById(25);
//		genero2.setDescricao("Paixão");
//		generoDaoJDBC.update(genero2);
		System.out.println(genero2);

		System.out.println("\nExcluir");
		Genero genero3 = generoDaoJDBC.findById(25);
//		generoDaoJDBC.deleteById(genero3); 

		System.out.println("\nfindById");
		Genero genero4 = generoDaoJDBC.findById(24);
		System.out.println(genero4.toString());

		System.out.println("\nfindAll");
		List<Genero> generos = generoDaoJDBC.listagenero();
		for (Genero genero5 : generos) {
			System.out.println(genero5);
		}

	}

}
