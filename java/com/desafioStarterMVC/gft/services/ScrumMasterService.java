package com.desafioStarterMVC.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafioStarterMVC.gft.entities.ScrumMaster;
import com.desafioStarterMVC.gft.repositories.ScrumMasterRepository;


@Service
public class ScrumMasterService {
	
	@Autowired
	ScrumMasterRepository scrumMasterRepository;
	
	
	
	
	public List<ScrumMaster> listarScrumMaster(){
		
		return scrumMasterRepository.findAll();
	}
	
	public ScrumMaster salvarScrumMaster(ScrumMaster scrumMaster) {
		
		try {
			scrumMasterRepository.save(scrumMaster);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return scrumMaster;
	}
	
	public ScrumMaster obterScrumMaster (Long id) {
		
		Optional <ScrumMaster> smId = scrumMasterRepository.findById(id);
	
		return smId.get();
	}

	
	public void excluirScrumMaster (Long id) {
		
		scrumMasterRepository.deleteById(id);
	}

}
