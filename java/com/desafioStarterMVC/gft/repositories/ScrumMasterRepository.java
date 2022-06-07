package com.desafioStarterMVC.gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioStarterMVC.gft.entities.ScrumMaster;

@Repository
public interface ScrumMasterRepository extends JpaRepository< ScrumMaster, Long> {
	

}
