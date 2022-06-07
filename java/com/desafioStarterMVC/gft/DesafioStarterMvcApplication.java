package com.desafioStarterMVC.gft;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.desafioStarterMVC.gft.entities.Starter;
import com.desafioStarterMVC.gft.entities.Usuario;
import com.desafioStarterMVC.gft.mail.MailSend;
import com.desafioStarterMVC.gft.mail.Mensagem;
import com.desafioStarterMVC.gft.repositories.StarterRepository;
import com.desafioStarterMVC.gft.repositories.UsuarioRepository;


@SpringBootApplication
public class DesafioStarterMvcApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioStarterMvcApplication.class, args);		
		System.out.print(new BCryptPasswordEncoder().encode("Gft2021"));
	}
		
}


