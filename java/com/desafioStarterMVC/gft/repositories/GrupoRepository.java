package com.desafioStarterMVC.gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioStarterMVC.gft.entities.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository <Grupo,Long> {
	
	List<Grupo> findAll();

}
