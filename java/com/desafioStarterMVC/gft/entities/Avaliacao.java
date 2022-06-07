 package com.desafioStarterMVC.gft.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(cascade=CascadeType.REMOVE)
	private Starter starter;
	
	@OneToOne
	private Modulo modulo;


    public Modulo getModulo() {
		return modulo;
	}


	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}


	@Lob
	private String observacao;
	
	
	private float notaDeAvaliacao;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public float getNotaDeAvaliacao() {
		return notaDeAvaliacao;
	}


	public void setNotaDeAvaliacao(float notaDeAvaliacao) {
		this.notaDeAvaliacao = notaDeAvaliacao;
	}

	public Starter getStarter() {
		return starter;
	}


	public void setStarter(Starter starter) {
		this.starter = starter;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	
	

}
