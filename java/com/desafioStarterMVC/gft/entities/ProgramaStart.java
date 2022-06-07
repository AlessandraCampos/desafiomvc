 package com.desafioStarterMVC.gft.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;






@Entity
public class ProgramaStart {
	
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Este Campo não pode ser vazio")
	private String nomePrograma;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataInicial;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataFinal;
	
	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePrograma() {
		return nomePrograma;
	}

	public void setNomePrograma(String nomePrograma) {
		this.nomePrograma = nomePrograma;
	}



	public LocalDate getDataInicial() {
		return dataInicial;
	}



	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}



	public LocalDate getDataFinal() {
		return dataFinal;
	}



	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}








	
	

}
