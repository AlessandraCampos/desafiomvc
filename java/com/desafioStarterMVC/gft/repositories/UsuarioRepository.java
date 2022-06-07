package com.desafioStarterMVC.gft.repositories;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafioStarterMVC.gft.entities.Usuario;




@Repository
public interface UsuarioRepository extends CrudRepository <Usuario,String>{

	Usuario findByLogin(String login);
}
