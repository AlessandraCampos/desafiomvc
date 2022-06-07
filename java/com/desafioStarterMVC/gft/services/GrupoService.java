package com.desafioStarterMVC.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioStarterMVC.gft.entities.Grupo;
import com.desafioStarterMVC.gft.repositories.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
	GrupoRepository grupoRepository;
	

	
	
	public List<Grupo> listarGrupo(){
		return grupoRepository.findAll();
	}
	
	
	
	public Grupo salvarGrupo(Grupo grupo) {

		try {
			grupoRepository.save(grupo);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return grupo;
	}
	

	
	
	public Grupo obterGrupo(Long id) {

		Optional< Grupo> grupoById = grupoRepository.findById(id);

		return grupoById.get();
	}

	
	public void excluirGrupo(Long id) {
		grupoRepository.deleteById(id);
	}

	
	
}

	
	
	
	


