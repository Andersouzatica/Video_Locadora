package view;

import java.sql.SQLException;
import java.util.List;

import model.entities.Filme2;
import model.entities.Genero;
import model.entities.dao.DaoFactory;
import model.entities.dao.Filme2Dao;
import model.entities.dao.GeneroDao;

public class teste {

	public static void main(String[] args) throws SQLException {

		Filme2Dao filme2Dao = DaoFactory.createFilmeDao2();
		Genero genero = new Genero();
//		Filme2 filme2 = new Filme2(null, "teste", genero, "Fime bom", 180);
//		filme2Dao.inserir(filme2);
//		System.out.println("Insertido! novo id = " + filme2.getCodFilme());

		Filme2 filme2 = new Filme2();
//		List<Filme2> filme2s = filme2Dao.findAll();
//		for (Filme2 filme22 : filme2s) {
//			System.out.println(filme22);
//		}
		filme2 = filme2Dao.findById(3);
//		filme2.setTitulo("Branca de Neves");
//		filme2.setGenero(genero);
//		filme2Dao.update(filme2);
		System.out.println("Atualizado");
		
		Filme2 filme22 = filme2Dao.findById(4);
		System.out.println(filme22);
		
		
		filme2Dao.deleteById(filme22);
		System.out.println("Excuido");
	}
}
