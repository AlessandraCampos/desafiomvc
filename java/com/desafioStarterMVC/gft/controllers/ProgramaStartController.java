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
import com.desafioStarterMVC.gft.entities.ProgramaStart;
import com.desafioStarterMVC.gft.services.ProgramaStartService;

@Controller
@RequestMapping("programas")
public class ProgramaStartController {
	
	@Autowired
	ProgramaStartService programaStartService;
	
	
	@RequestMapping()
	public ModelAndView listarProgramas() {
		
		List <ProgramaStart> programas = programaStartService.listarProgramas();
		ModelAndView mv = new ModelAndView("programas/listar.html");
		mv.addObject("listarProgramas",programas );
		
		return mv;
		
		
	}
	
	
	@RequestMapping(method= RequestMethod.GET, path="editar")
	public ModelAndView novoDesenvolvedor(@RequestParam (required= false) Long id) {
		
		ModelAndView mv = new ModelAndView("programas/form.html");
		
		ProgramaStart programas;
		
		if(id == null ) {
			programas =  new ProgramaStart();
			
		}else {
			try {
				programas = programaStartService.obterPrograma(id);
			}catch(Exception e ){
				programas =  new ProgramaStart();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		mv.addObject("programas",programas);
	    mv.addObject("listaProgramas", programaStartService.listarProgramas());
	   // mv.addObject("listaGrupos", grupoService.listarGrupo());
	    
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST, path="editar")
	public ModelAndView salvarPrograma(@Valid ProgramaStart programas, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("programas/form.html");
		
       boolean novo = true;
		
		if(programas.getId()!=null) {
			novo=false;
		}
		if (bindingResult.hasErrors()) {
			mv.addObject("programas",programas);
			return mv;
		}
		

		
	if (programas.getDataInicial().isAfter(programas.getDataFinal())== false) {
			
			programaStartService.salvarPrograma(programas);
			
			
			if(novo) {
				mv.addObject("programas",new ProgramaStart());
			}else {
				mv.addObject("programas", programas);
			}
			
			
			mv.addObject("mensagem","Programa Salvo Com Sucesso");
			
			
		}else {
			mv.addObject("programas",programas);
			mv.addObject("mensagem","A data inicial deve ser menor que a data final");
		}
		
		


		
		return mv;
	}
	
	@RequestMapping(path="excluir")
	public  ModelAndView excluirPrograma(@RequestParam Long id , RedirectAttributes redirectAttributes) {
		
		 ModelAndView mv = new  ModelAndView("redirect:/programas");
	
		 try {
			 programaStartService.excluirPrograma(id);
			 redirectAttributes.addFlashAttribute("mensagem", "Programa Excluído com Sucesso");
		 }catch(Exception e){
			 redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
		 }
		
		 return mv;
		
		
	}
	
	
	

}
