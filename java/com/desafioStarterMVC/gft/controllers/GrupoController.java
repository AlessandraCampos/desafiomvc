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
import com.desafioStarterMVC.gft.entities.ScrumMaster;
import com.desafioStarterMVC.gft.entities.Starter;
import com.desafioStarterMVC.gft.services.GrupoService;
import com.desafioStarterMVC.gft.services.ModuloService;
import com.desafioStarterMVC.gft.services.ScrumMasterService;
import com.desafioStarterMVC.gft.services.TecnologiaService;

@Controller
@RequestMapping("grupo")
public class GrupoController {
	
	
	@Autowired
	 private GrupoService grupoService;
	
	 @Autowired
     ModuloService moduloService;
	
	 @Autowired
	 TecnologiaService tecnologiaService;
	 
	 @Autowired
	 ScrumMasterService scrumMasterService;
	 
	 Starter starter;
	
	@Autowired
	@RequestMapping()
	public ModelAndView listarGrupos () {
	   
		 List<Grupo> grupos = grupoService.listarGrupo();
		ModelAndView mv = new ModelAndView("grupos/listar.html");
		mv.addObject("listarGrupos", grupos);
		mv.addObject("listaTecnologia",tecnologiaService.listarTecnologias());
		return mv;
	}
	

	@RequestMapping(method= RequestMethod.GET, path="editar")
	public ModelAndView salvarGrupo(@RequestParam (required= false) Long id) {
		
		ModelAndView mv = new ModelAndView("grupos/form.html");
	
		Grupo grupo;
		
		if(id== null) {
			grupo= new Grupo();
		}else {
			try {
				grupo = grupoService.obterGrupo(id);
			}catch(Exception e ){
				grupo = new Grupo(); 
				mv.addObject("mensagem", e.getMessage());
			}
		}
		
		mv.addObject("listaTecnologia",tecnologiaService.listarTecnologias());
		mv.addObject("listaScrum",scrumMasterService.listarScrumMaster());
		mv.addObject("listaModulo",moduloService.listarModulo());
		
		
		mv.addObject("grupo",grupo );
		return mv;
		
		
	}
	
	
	@RequestMapping(method= RequestMethod.POST, path="editar")
	public ModelAndView salvarGrupo(@Valid Grupo grupo,BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("grupos/form.html");
		
      boolean novo = true;
		
		if(grupo.getId()!=null) {
			novo=false;
		}
		if (bindingResult.hasErrors()) {
			mv.addObject("grupo",grupo);
		return mv;
		}
		

		List<Grupo> verificaId = grupoService.listarGrupo();	
		List<Grupo> verificaIdFiltrada = verificaId.stream().filter(x -> x.getScrumMaster().getId().equals(grupo.getScrumMaster().getId())).toList();

		
		if(verificaIdFiltrada.size() > 0)
		{
			mv.addObject("grupo", grupo);
			mv.addObject("listaTecnologia",tecnologiaService.listarTecnologias());
			mv.addObject("listaScrum",scrumMasterService.listarScrumMaster());
			mv.addObject("listaModulo",moduloService.listarModulo());
			mv.addObject("mensagem","Já existe esse ScrumMaster em outro grupo");
		}
		else
		{
			grupoService.salvarGrupo(grupo);
		
		
			if(novo) {
				mv.addObject("grupo",new Grupo());
			}else {
				mv.addObject("grupo", grupo);
			}
			mv.addObject("mensagem","Grupo Salvo Com Sucesso");
		}
		
//		Boolean igualdade= verificaId.equals(scrumMasterService.obterScrumMaster(valid));
//		System.out.print("Os Ids sao iguais?"+ igualdade);
//		if (igualdade) {
//			
//		System.out.print("Resultado" + igualdade);
		
		
		
		return mv;
	}
	

	@RequestMapping(path="excluir")
	public ModelAndView excluirGrupo(@RequestParam Long id , RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/grupo");
		
		try {
			
			List<ScrumMaster> listaScrumMaster = scrumMasterService.listarScrumMaster()
					.stream().filter(x -> x
					.getId()== id)
					.collect(Collectors.toList());
			System.out.println(listaScrumMaster);
			if(listaScrumMaster.size() <= 0) {
	
			grupoService.excluirGrupo(id);
			redirectAttributes.addFlashAttribute("mensagem", "Grupo Excluído com Sucesso");
			
		}else {
			redirectAttributes.addFlashAttribute("mensagem", "Este Grupo está associado a um Scrum Master");
		}
			
		}catch(Exception e){
			
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
			
		}

		return mv;
	}
		
	}
	
	





