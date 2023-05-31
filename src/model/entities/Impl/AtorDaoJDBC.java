package model.entities.Impl;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Ator;
import model.entities.Pais;
import model.entities.dao.AtorDao;

public class AtorDaoJDBC implements AtorDao {
	
	
	
	Connection conn;
	
	public AtorDaoJDBC(Connection conn) {
		this.conn =conn; 
	}

	@Override
	public void insert(Ator obj) throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO ator (nome, codpais) VALUES (?,?)");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getPais().getCodpais());
			st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
		}
	}

	@Override
	public void update(Ator obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Ator obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ator> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ator findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pais> findPais() throws SQLException {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("SELECT * FROM pais order by descricao desc");
			ResultSet rs = st.executeQuery();
			List<Pais> list = new ArrayList<>();
			while(rs.next()) {
				Pais pais = new Pais();
				pais.setCodpais(rs.getInt("codpais"));
				pais.setDescricao(rs.getString("descricao"));
				list.add(pais);
			}
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			st.close();
		}
		return null;
	}

}
