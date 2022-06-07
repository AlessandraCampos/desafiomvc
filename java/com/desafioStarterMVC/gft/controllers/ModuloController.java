package com.desafioStarterMVC.gft.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafioStarterMVC.gft.entities.Avaliacao;
import com.desafioStarterMVC.gft.entities.Grupo;
import com.desafioStarterMVC.gft.entities.Modulo;
import com.desafioStarterMVC.gft.services.AvaliacaoService;
import com.desafioStarterMVC.gft.services.DailyService;
import com.desafioStarterMVC.gft.services.ModuloService;




@Controller
@RequestMapping("modulos")
public class ModuloController {
	
	@Autowired
	ModuloService moduloService;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@Autowired
	DailyService dailyService;
	
	
	@RequestMapping
	public ModelAndView listarModulo() {
		
		List <Modulo> modulos = moduloService.listarModulo();
	
		
		ModelAndView mv = new ModelAndView("modulos/listar.html");
		
		mv.addObject("listarModulo",modulos);		
		mv.addObject("listaravaliacao",avaliacaoService.listarAvaliacao());


		return mv;
		
	}
	
	
	@RequestMapping(method= RequestMethod.GET, path="editar")
	public ModelAndView novoModulo(@RequestParam (required= false) Long id) {
		
		ModelAndView mv = new ModelAndView("modulos/form.html");
		
		Modulo modulo;
		
		if(id == null ) {
			modulo =  new Modulo();
			
		}else {
			try {
				modulo = moduloService.obterModulo(id);
				
			}catch(Exception e ){
				modulo =  new Modulo();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		mv.addObject("modulo",modulo);
	
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST, path="editar")
	public ModelAndView salvarModulo(@Valid Modulo modulo, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("modulos/form.html");
		
       boolean novo = true;
		
		if(modulo.getId()!=null) {
			novo=false;
		}
		if (bindingResult.hasErrors()) {
			mv.addObject("modulo",modulo);
			return mv;
		}
		
		moduloService.salvarModulo(modulo);
		
		if(novo) {
			mv.addObject("modulo",new Modulo());
		}else {
			mv.addObject("modulo", modulo);
		}
		
		mv.addObject("modulo", modulo);
		mv.addObject("mensagem","Modulo Salvo Com Sucesso");
		
		
		return mv;
	}
	
	@RequestMapping(path="excluir")
	public ModelAndView excluirModulo(@RequestParam Long id , RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/modulos");
		
		try { 
			
			     moduloService.excluirModulo(id);
			     redirectAttributes.addFlashAttribute("mensagem", "Este Módulo está excluido");
		           
			
		}catch(Exception e){
			
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
			
		}

		return mv;
	}
	
		
}
