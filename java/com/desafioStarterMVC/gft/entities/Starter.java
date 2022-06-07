 package com.desafioStarterMVC.gft.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Starter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Campo Nome não pode ser vazio")
	@NotNull(message="O Nome não pode ser nulo")
	private String nome;
	
	@NotEmpty(message="Este Campo não pode ser vazio")
	@NotNull(message="Este Campo não pode ser nulo")
	private String quatroLetras;
	
	@OneToOne//(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Grupo grupo;
	
	@OneToOne
	private ProgramaStart programaStart;
	
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public ProgramaStart getProgramaStart() {
		return programaStart;
	}

	public void setProgramaStart(ProgramaStart programaStart) {
		this.programaStart = programaStart;
	}

	
	

	private String imagem;
	


	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuatroLetras() {
		return quatroLetras;
	}

	public void setQuatroLetras(String quatroLetras) {
		this.quatroLetras = quatroLetras;
	}
	

}
