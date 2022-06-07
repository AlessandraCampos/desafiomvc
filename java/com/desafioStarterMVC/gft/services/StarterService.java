package com.desafioStarterMVC.gft.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafioStarterMVC.gft.entities.Starter;
import com.desafioStarterMVC.gft.repositories.StarterRepository;



@Service
public class StarterService {

	@Autowired
	StarterRepository starterRepository;

	public Starter salvarStarter(Starter starter) {

		try {
			starterRepository.save(starter);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return starter;
	}
	
	public List<Starter> listarStarters() {

		return starterRepository.findAll();

	 
	}
	
	
	public Starter obterStarter(Long id) {

		Optional<Starter> idStarter = starterRepository.findById(id);

		return idStarter.get();
	}

	
	public void excluirStarter(Long id) {
		starterRepository.deleteById(id);
	}

	
	
}
