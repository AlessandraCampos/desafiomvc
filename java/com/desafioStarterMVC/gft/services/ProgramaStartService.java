package com.desafioStarterMVC.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioStarterMVC.gft.entities.ProgramaStart;
import com.desafioStarterMVC.gft.repositories.ProgramaStartRepository;

@Service
public class ProgramaStartService {
	
	@Autowired
	ProgramaStartRepository programaStartRepository;
	
	
	public List<ProgramaStart> listarProgramas(){
		return programaStartRepository.findAll();
	}
	
	public ProgramaStart salvarPrograma(ProgramaStart programa) {
		
		
		
		return  programaStartRepository.save(programa);
		
		
	}
	
	public ProgramaStart obterPrograma(Long id)  {
	
		Optional<ProgramaStart> programa = programaStartRepository.findById(id);
		return programa.get();
	}
	
	public void excluirPrograma(Long id ) {
		
		 programaStartRepository.deleteById(id);
	}

}
