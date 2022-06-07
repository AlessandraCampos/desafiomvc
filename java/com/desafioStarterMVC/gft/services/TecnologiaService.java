package com.desafioStarterMVC.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioStarterMVC.gft.entities.Tecnologia;
import com.desafioStarterMVC.gft.repositories.TecnologiaRepository;

@Service
public class TecnologiaService {
	
	
	@Autowired
	TecnologiaRepository tecnologiaRepository;
	
	
	public List<Tecnologia> listarTecnologias(){
		
		return tecnologiaRepository.findAll();
	}
	
	public Tecnologia salvarTecnologia( Tecnologia tecnologia) {
		
		try {
			tecnologiaRepository.save(tecnologia);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tecnologia;
	}
	
	public Tecnologia obterTecnologia (Long id) {
		
		Optional <Tecnologia> tecId = tecnologiaRepository.findById(id);
	
		return tecId.get();
	}

	
	public void excluirTecnologia (Long id) {
		
		tecnologiaRepository.deleteById(id);
	}
}
