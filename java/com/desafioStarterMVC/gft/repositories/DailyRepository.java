package com.desafioStarterMVC.gft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioStarterMVC.gft.entities.Daily;

@Repository
public interface DailyRepository extends JpaRepository <Daily, Long> {

}
