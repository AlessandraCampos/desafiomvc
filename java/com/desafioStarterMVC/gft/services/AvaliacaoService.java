package com.desafioStarterMVC.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioStarterMVC.gft.entities.Avaliacao;
import com.desafioStarterMVC.gft.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	
	
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	
	public List<Avaliacao> listarAvaliacao(){
		
		return avaliacaoRepository.findAll();
	}
	
	
	public Avaliacao obterAvaliacao(Long id) {
		
		Optional<Avaliacao> avaliacaoId = avaliacaoRepository.findById(id);
		
		return avaliacaoId.get();
			
		}
		



	
	public Avaliacao salvarAvaliacao(Avaliacao avaliacao) {
		try {
				
		 avaliacaoRepository.save(avaliacao);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return avaliacao;
		 
	}
	
	

	
	public void excluirAvaliacao(Long id) {
	     avaliacaoRepository.deleteById(id);
	}
}
