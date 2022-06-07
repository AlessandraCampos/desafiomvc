package com.desafioStarterMVC.gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioStarterMVC.gft.entities.Daily;
import com.desafioStarterMVC.gft.repositories.DailyRepository;

@Service
public class DailyService {
	
	
	@Autowired
	DailyRepository dailyRepository;
		

		
		
		public List<Daily> listarDaily(){
			return dailyRepository.findAll();
		}
		
		
		
		public Daily salvarDaily(Daily daily) {

			try {
				dailyRepository.save(daily);

			} catch (Exception e) {
				e.printStackTrace();

			}

			return daily;
		}
		

		
		
		public Daily obterDaily(Long id) {

			Optional< Daily> dailyById = dailyRepository.findById(id);

			return dailyById.get();
		}

		
		public void excluirDaily(Long id) {
			dailyRepository.deleteById(id);
		}

		
		
	}

		
		
		
		





