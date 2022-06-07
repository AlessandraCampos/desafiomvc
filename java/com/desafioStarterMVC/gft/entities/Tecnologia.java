package com.desafioStarterMVC.gft.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;

@Entity
public class Tecnologia {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Este campo não pode ficar vazio")
	private String nomeTecnologia;
	
	@Lob
	private String  descricao;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTecnologia() {
		return nomeTecnologia;
	}

	public void setNomeTecnologia(String nomeTecnologia) {
		this.nomeTecnologia = nomeTecnologia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
