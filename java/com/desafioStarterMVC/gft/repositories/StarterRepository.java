package com.desafioStarterMVC.gft.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desafioStarterMVC.gft.entities.Starter;
import com.desafioStarterMVC.gft.entities.Usuario;





@Repository
public interface StarterRepository extends JpaRepository<Starter, Long>{
}
