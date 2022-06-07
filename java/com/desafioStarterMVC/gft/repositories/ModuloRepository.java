package com.desafioStarterMVC.gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioStarterMVC.gft.entities.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo,Long>{

}
