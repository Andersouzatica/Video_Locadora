package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Filme {

	private Integer codFilme;
	private String titulo;
	private String genero;
	private String sinopse;
	private Integer duracao;
	private List<Item> itens = new ArrayList<>();
	private List<Ator> atores = new ArrayList<>();

	public Filme(String titulo, String genero, String sinopse, Integer duracao) {
		this.titulo = titulo;
		this.genero = genero;
		this.sinopse = sinopse;
		this.duracao = duracao;

	}

	public Filme() {
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
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
		return "Filme [codFilme=" + codFilme + ", titulo=" + titulo + ", genero=" + genero + ", sinopse=" + sinopse
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
		Filme other = (Filme) obj;
		return Objects.equals(codFilme, other.codFilme);
	}
	


}
