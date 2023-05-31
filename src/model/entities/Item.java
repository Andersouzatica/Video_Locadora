package model.entities;

import java.util.Date;
import java.util.Objects;

public class Item {
	
	private Integer codItem;
	private Double preco;
	private String tipo;
	private Date dataLocacao;
	private Date dataDevolucao;
	private Filme filme;
	private Cliente cliente;
	public Integer getCodItem() {
		return codItem;
	}
	public void setCodItem(Integer codItem) {
		this.codItem = codItem;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Item [codItem=" + codItem + ", preco=" + preco + ", tipo=" + tipo + ", dataLocacao=" + dataLocacao
				+ ", dataDevolucao=" + dataDevolucao + ", filme=" + filme + ", cliente=" + cliente + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(codItem);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(codItem, other.codItem);
	}
	
	
	


}
