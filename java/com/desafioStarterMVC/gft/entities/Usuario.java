package com.desafioStarterMVC.gft.entities;

import java.util.Arrays;
import java.util.Collection;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
public class Usuario implements UserDetails{
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	    private Long id; 
		 public Long getId() {
		   return id; 
	   }
	
	 public void setId(Long id) {
		  this.id = id; 
		  }
	 
		 
		private String nomeCompleto;
		
		public String getAutorizacao() {
			return autorizacao;
		}

		public void setAutorizacao(String autorizacao) {
			this.autorizacao = autorizacao;
		}


		private String autorizacao;
		
	  
		public String getNomeCompleto() {
			return nomeCompleto;
		}
		
		
		
		private String login;
		
		
		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public void setNomeCompleto(String nomeCompleto) {
			this.nomeCompleto = nomeCompleto;
		}


		private String senha;
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() { 
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(getAutorizacao());
		  	return Arrays.asList(authority);
			
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return senha;
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return login;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		


}
		

		
		
		
		

	