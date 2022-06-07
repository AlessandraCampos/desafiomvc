package com.desafioStarterMVC.gft.security;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.desafioStarterMVC.gft.entities.Usuario;
import com.desafioStarterMVC.gft.mail.MailSend;
import com.desafioStarterMVC.gft.mail.Mensagem;
import com.desafioStarterMVC.gft.repositories.UsuarioRepository;


@Repository
public class ImplementsUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
    MailSend emailRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {		
		
	      Usuario usuario = usuarioRepository.findByLogin(login);
	      
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		
		if(usuario.getAutorizacao().equals("ROLE_USER"))
		{
			emailRepository.enviar(new Mensagem("Scrum Master acessou o Sistema<alecampos.dev@gmail.com>", 
					"Desafio MVC <clecio.silva@gft.com>"
			, "Desafio MVC-Scrum Master", "Olá Admin! \n\n O Scrum Master acabou de acessar o Sistema! - Hora: " + LocalDateTime.now()));
		}
		
		return usuario;
	}

}
