 package com.desafioStarterMVC.gft.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Daily {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@NotEmpty(message="Campo Nome não pode ser vazio")
	private LocalDate data;
	
	
	private Boolean sim;
	private Boolean nao;
	
	//@NotEmpty(message="Campo Nome não pode ser vazio")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(cascade=CascadeType.REMOVE)
	private Starter starter;
	
	@OneToOne
	private DailyStatus status;
	
	public DailyStatus getStatus() {
		return status;
	}

	public String getImpedimentos() {
		return impedimentos;
	}

	public void setImpedimentos(String impedimentos) {
		this.impedimentos = impedimentos;
	}

	public void setStatus(DailyStatus status) {
		this.status = status;
	}

	@ManyToOne
	private Modulo modulo;
	
	@Lob
	private String observacao;
	
	@Lob
	private String impedimentos;
	
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Boolean getSim() {
		return sim;
	}

	public void setSim(Boolean sim) {
		this.sim = sim;
	}

	public Boolean getNao() {
		return nao;
	}

	public void setNao(Boolean nao) {
		this.nao = nao;
	}

	public Starter getStarter() {
		return starter;
	}

	public void setStarter(Starter starter) {
		this.starter = starter;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	

}
