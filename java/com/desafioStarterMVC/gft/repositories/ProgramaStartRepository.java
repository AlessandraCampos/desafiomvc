package com.desafioStarterMVC.gft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioStarterMVC.gft.entities.ProgramaStart;

@Repository
public interface ProgramaStartRepository  extends JpaRepository <ProgramaStart, Long>{
	List<ProgramaStart> findAll();

}
