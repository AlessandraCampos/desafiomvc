package com.desafioStarterMVC.gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioStarterMVC.gft.entities.Tecnologia;

@Repository
public interface TecnologiaRepository extends JpaRepository <Tecnologia, Long> {

}
