package com.desafioStarterMVC.gft.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafioStarterMVC.gft.entities.Tecnologia;
import com.desafioStarterMVC.gft.services.TecnologiaService;

@Controller
@RequestMapping("tecnologia")
public class TecnologiaController {
	
	@Autowired
	 private TecnologiaService tecnologiaService;
	
	
	@Autowired
	@RequestMapping()
	public ModelAndView listarTecnologias () {
	   
		 List<Tecnologia>tecnologias = tecnologiaService.listarTecnologias();
		ModelAndView mv = new ModelAndView("tecnologias/listar.html");
		mv.addObject("listarTecnologias", tecnologias);
		
		return mv;
	}
	

	@RequestMapping(method= RequestMethod.GET, path="editar")
	public ModelAndView salvarTecnologia(@RequestParam (required= false) Long id) {
		
		ModelAndView mv = new ModelAndView("tecnologias/form.html");
	
		Tecnologia tecnologia;
		
		if(id== null) {
			tecnologia = new Tecnologia();
		}else {
			try {
				tecnologia = tecnologiaService.obterTecnologia(id);
			}catch(Exception e ){
				tecnologia = new Tecnologia(); 
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		
		
		
		mv.addObject("tecnologia",tecnologia );
		return mv;
		
		
	}
	
	
	@RequestMapping(method= RequestMethod.POST, path="editar")
	public ModelAndView salvarPrograma(@Valid Tecnologia tecnologia,BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("tecnologias/form.html");
		
       boolean novo = true;
		
		if(tecnologia.getId()!=null) {
			novo=false;
		}
		if (bindingResult.hasErrors()) {
			mv.addObject("tecnologia",tecnologia);
		return mv;
		}
		
		tecnologiaService.salvarTecnologia(tecnologia);
		
		
		if(novo) {
			mv.addObject("tecnologia",new Tecnologia());
		}else {
			mv.addObject("tecnologia", tecnologia);
		}
		
		
		mv.addObject("mensagem","Tecnologia Salvo Com Sucesso");
		
		
		return mv;
	}
	
	@RequestMapping(path="excluir")
	public ModelAndView excluirTecnologia(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/tecnologia");
		try {
			tecnologiaService.excluirTecnologia(id);
			redirectAttributes.addFlashAttribute("mensagem", "Tecnologia Excluída com Sucesso");
		}catch(Exception e){
			
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
		
		
	}
		return mv;
	
	}
	
	

}
