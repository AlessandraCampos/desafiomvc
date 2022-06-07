package com.desafioStarterMVC.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioStarterMVC.gft.entities.Modulo;
import com.desafioStarterMVC.gft.repositories.ModuloRepository;

@Service
public class ModuloService {
	
	@Autowired
	ModuloRepository moduloRepository;
	
	
	public List<Modulo> listarModulo (){
		
		return moduloRepository.findAll();
	}
	
	
	public Modulo obterModulo(Long id) {
		Optional<Modulo> moduloId = moduloRepository.findById(id);
		
		return moduloId.get();
	}
	
	
	public Modulo salvarModulo(Modulo modulo) {

		try {
			moduloRepository.save(modulo);

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return modulo;
	}
	

	
	public void excluirModulo(Long id) {
		
		moduloRepository.deleteById(id);
		
	}
}
