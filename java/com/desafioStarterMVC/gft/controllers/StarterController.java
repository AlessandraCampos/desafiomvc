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
import com.desafioStarterMVC.gft.entities.Grupo;
import com.desafioStarterMVC.gft.entities.Starter;
import com.desafioStarterMVC.gft.services.GrupoService;
import com.desafioStarterMVC.gft.services.ProgramaStartService;
import com.desafioStarterMVC.gft.services.StarterService;




@Controller
@RequestMapping("starter")
public class StarterController {
	
	@Autowired
     StarterService staterService;
	
	@Autowired
	ProgramaStartService programaStartService;
	
	@Autowired
    GrupoService grupoService;

	
	
	@RequestMapping(method= RequestMethod.GET, path="editar")
	public ModelAndView novoDesenvolvedor(@RequestParam (required= false) Long id) {
		
		ModelAndView mv = new ModelAndView("starter/form.html");
		
		Starter starter;
		
		if(id == null ) {
			starter =  new Starter();
			
		}else {
			try {
				starter = staterService.obterStarter(id);
			}catch(Exception e ){
				starter =  new Starter();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		mv.addObject("starter",starter);
	    mv.addObject("listaProgramas", programaStartService.listarProgramas());
	    mv.addObject("listaGrupos", grupoService.listarGrupo());
	    
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST, path="editar")
	public ModelAndView salvarDesenvolvedor(@Valid Starter starter, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("starter/form.html");
		
       boolean novo = true;
		
		if(starter.getId()!=null) {
			novo=false;
		}
		if (bindingResult.hasErrors()) {
			mv.addObject("starter",starter);
			return mv;
		}
		
		staterService.salvarStarter(starter);
		
		if(novo) {
			mv.addObject("starter",new Starter());
		}else {
			mv.addObject("starter", starter);
		}
		
		
		mv.addObject("mensagem","Starter Salvo Com Sucesso");
	
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView listarStarter () {
		
		List <Starter>starters = this.staterService.listarStarters();
		
		ModelAndView mv = new ModelAndView("starter/listar.html");
		
		mv.addObject("lista", starters);		//
	    mv.addObject("grupo", grupoService.listarGrupo());
		
		return mv;
	}
	
	@RequestMapping(path="excluir")
	public ModelAndView excluirStarter(@RequestParam Long id , RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/starter");
		
		try {
		
			 List<Grupo> listaGrupo = grupoService.listarGrupo()
						.stream().filter(x -> x
						.getId()== id)
						.collect(Collectors.toList());
						
				
				         if(listaGrupo.size() <= 0 ) {
					
		
					        	staterService.excluirStarter(id);
					 			redirectAttributes.addFlashAttribute("mensagem", "Starter Excluído com Sucesso");
					        	 
					         }else {
							     redirectAttributes.addFlashAttribute("mensagem", "Este Starter está associado a um grupo");
					           }
			
			
		}catch(Exception e){
			
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
			
		}

		return mv;
	}
}
