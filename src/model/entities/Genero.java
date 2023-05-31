package model.entities;

import java.util.Objects;

public class Genero {
	private Integer codGenero;
	private String descricao;

	public Genero() {
	}

	public Genero(Integer codGenero, String descricao) {
		this.codGenero = codGenero;
		this.descricao = descricao;
	}

	public Integer getCodGenero() {
		return codGenero;
	}

	public void setCodGenero(Integer codGenero) {
		this.codGenero = codGenero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codGenero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		return Objects.equals(codGenero, other.codGenero);
	}

}
