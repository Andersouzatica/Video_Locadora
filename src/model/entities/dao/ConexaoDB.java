package model.entities.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDB {

		public static Connection getConexao() {

			Connection con = null;

			try {
				String dbURL = "jdbc:mysql://localhost:3306/MVC?useTimezone=true&serverTimezone=UTC";
				String username = "root";
				String password = "imip0001";

				con = DriverManager.getConnection(dbURL, username, password);

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "ConexaoDAO-" + erro.getMessage());
			}

			return con;

		}

}
