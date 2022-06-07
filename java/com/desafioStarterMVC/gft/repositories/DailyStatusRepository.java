package com.desafioStarterMVC.gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioStarterMVC.gft.entities.DailyStatus;

@Repository
public interface DailyStatusRepository extends JpaRepository <DailyStatus , Long>{

}
