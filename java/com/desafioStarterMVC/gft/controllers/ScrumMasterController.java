package com.desafioStarterMVC.gft.controllers;

import org.springframework.stereotype.Controller;

import com.desafioStarterMVC.gft.services.ScrumMasterService;


import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafioStarterMVC.gft.entities.Grupo;
import com.desafioStarterMVC.gft.entities.ScrumMaster;
import com.desafioStarterMVC.gft.entities.Starter;
import com.desafioStarterMVC.gft.services.GrupoService;



@Controller
@RequestMapping("scrum")
public class ScrumMasterController {
	
	@Autowired
	ScrumMasterService scrumMasterService;
	
	@Autowired
	GrupoService grupoService;
	
		
		@RequestMapping(method= RequestMethod.GET, path="editar")
		public ModelAndView novoScrumMaster(@RequestParam (required= false) Long id) {
			
			ModelAndView mv = new ModelAndView("scrum/form.html");
			
			ScrumMaster scrumMaster;
			
			if(id == null) {
				scrumMaster =  new ScrumMaster();
				
			}else {
				try {
					scrumMaster = scrumMasterService.obterScrumMaster(id);
				}catch(Exception e ){
					scrumMaster =  new ScrumMaster();
					mv.addObject("mensagem", e.getMessage());
				}
			}
			
			mv.addObject("scrumMaster",scrumMaster);
		
		    
		    
			return mv;
		}
		
		@RequestMapping(method= RequestMethod.POST, path="editar")
		public ModelAndView salvarDesenvolvedor(@Valid ScrumMaster scrumMaster, BindingResult bindingResult) {
			
			ModelAndView mv = new ModelAndView("scrum/form.html");
			
	       boolean novo = true;
			
			if(scrumMaster.getId()!=null) {
				novo=false;
			}
			if (bindingResult.hasErrors()) {
				mv.addObject("scrumMaster",scrumMaster);
				return mv;
			}
			
			scrumMasterService.salvarScrumMaster(scrumMaster);
			
			if(novo) {
				mv.addObject("scrum",new Starter());
			}else {
				mv.addObject("scrum", scrumMaster);
			}
			
			
			mv.addObject("mensagem","Scrum Master Salvo Com Sucesso");
			
			
			return mv;
		}
		
		@RequestMapping
		public ModelAndView listarScrumMaster () {
			
			List<ScrumMaster> scrumMaster = this.scrumMasterService.listarScrumMaster();
			
			ModelAndView mv = new ModelAndView("scrum/listar.html");
			
			
			mv.addObject("lista", scrumMaster);

			
			return mv;
		}
		
		@RequestMapping(path="excluir")
		public ModelAndView excluirStarter(@RequestParam Long id , RedirectAttributes redirectAttributes) {
			
			ModelAndView mv = new ModelAndView("redirect:/scrum");
			
			try {
			      List<Grupo> listaGrupo = grupoService.listarGrupo()
					.stream().filter(x -> x
					.getScrumMaster().getId()== id)
					.collect(Collectors.toList());
			
			         if(listaGrupo.size() <= 0 ) {
				
				     scrumMasterService.excluirScrumMaster(id);
				     redirectAttributes.addFlashAttribute("mensagem", "ScrumMaster Excluído com Sucesso");
			      }else {
				     redirectAttributes.addFlashAttribute("mensagem", "Este Scrum Master está associado a um grupo");
			           }
				
			}catch(Exception e){
				
				redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
				
			}

			return mv;
		}
	}



