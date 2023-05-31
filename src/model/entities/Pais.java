package model.entities;

import java.util.Objects;

public class Pais {
	
	private Integer codpais;
	private String descricao;
	
	public Pais(Integer codpais, String descricao) {
		this.codpais = codpais;
		this.descricao = descricao;
	}

	public Pais() {
	}

	public Integer getCodpais() {
		return codpais;
	}

	public void setCodpais(Integer codpais) {
		this.codpais = codpais;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codpais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(codpais, other.codpais);
	}
	
	
	
	
	
	

}
