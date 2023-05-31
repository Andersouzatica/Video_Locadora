package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ator {
	
	private Integer codAtor;
	private String name;
	private Pais pais;
	private List<Filme> filmes = new ArrayList<>();
	
	public Integer getCodAtor() {
		return codAtor;
	}
	public void setCodAtor(Integer codAtor) {
		this.codAtor = codAtor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}
	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Ator [codAtor=" + codAtor + ", name=" + name + ", filmes=" + filmes
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(codAtor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ator other = (Ator) obj;
		return Objects.equals(codAtor, other.codAtor);
	}
	
	

}
