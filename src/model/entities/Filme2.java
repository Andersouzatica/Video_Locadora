package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filme2 {

	private Integer codFilme;
	private String titulo;
	private Genero genero;
	private String sinopse;
	private Integer duracao;
	private List<Item> itens = new ArrayList<>();
	private List<Ator> atores = new ArrayList<>();

	

	public Filme2(Integer codFilme, String titulo, Genero genero, String sinopse, Integer duracao) {
		this.codFilme = codFilme;
		this.titulo = titulo;
		this.genero = genero;
		this.sinopse = sinopse;
		this.duracao = duracao;
	}

	public Filme2() {
	}

	public Integer getCodFilme() {
		return codFilme;
	}

	public void setCodFilme(Integer codFilme) {
		this.codFilme = codFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	@Override
	public String toString() {
		return "Filme [codFilme=" + codFilme + ", titulo=" + titulo + ", genero=" + genero.getCodGenero() + ", sinopse=" + sinopse
				+ ", duracao=" + duracao + ", itens=" + itens + ", atores=" + atores + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codFilme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme2 other = (Filme2) obj;
		return Objects.equals(codFilme, other.codFilme);
	}

}
