package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cliente {
	
	private Integer codCliente;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private Date dtNascimento;
	private List<Item> itens = new ArrayList<>();
	
	public Integer getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email
				+ ", endereco=" + endereco + ", dtNascimento=" + dtNascimento + ", itens=" + itens + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(codCliente);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(codCliente, other.codCliente);
	}

	
	
}
