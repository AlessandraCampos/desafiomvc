package com.desafioStarterMVC.gft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioStarterMVC.gft.entities.DailyStatus;
import com.desafioStarterMVC.gft.repositories.DailyStatusRepository;

@Service
public class DaillyStatusService {
	
	@Autowired
	DailyStatusRepository dailyStatusRepository;
	
	
	public List<DailyStatus> dailiesStatus (){
		
		return dailyStatusRepository.findAll();
	}

}
