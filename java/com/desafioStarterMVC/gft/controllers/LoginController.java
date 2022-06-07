//package com.desafioStarterMVC.gft.controllers;
//
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.desafioStarterMVC.gft.entities.Usuario;
//import com.desafioStarterMVC.gft.repositories.UsuarioRepository;
//
//
//import org.springframework.ui.Model;
//
//
//@Controller
//public class LoginController {
//	
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//	
//	@GetMapping("/login")
//	public String index() {
//		return "login/index";
//	}
//	
//	@PostMapping("/logar")
//	public String logar(Model model, Usuario userParam, HttpServletResponse response) {
//		
//		Usuario user = this.usuarioRepository.login(userParam.getLogin(),userParam.getSenha());
//		if(user !=null) {
//			
//
//			  
//			return "redirect:/";
//		}
//		model.addAttribute("erro", "Usuario ou senha inválidos");
//		return "login/index";
//	}
//
//}
