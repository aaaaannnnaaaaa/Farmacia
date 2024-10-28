package com.example.demo.entities;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Farmacia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Long idFornecedor;
	
	@NotNull
	@Size(min=3)
	private String nome;
	
	@NotNull
	private String bula;
	
	@Size(min=8)  //nove caracteres para o formato 01/01/01
	private String dataValidade;
	
	// metodos getts e setts

	// idFornecedor
	public Long getIdFornecedor() {
		return idFornecedor;
	}

	public void setidFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
	// nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// bula
	public String getBula() {
		return bula;
	}

	public void setBula(String bula) {
		this.bula = bula;
	}
	
	// dataValidade
	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

}
