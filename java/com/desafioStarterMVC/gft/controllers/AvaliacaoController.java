package com.desafioStarterMVC.gft.controllers;

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
import com.desafioStarterMVC.gft.services.AvaliacaoService;
import com.desafioStarterMVC.gft.services.ModuloService;
import com.desafioStarterMVC.gft.services.StarterService;

@Controller
@RequestMapping("avaliacao")
public class AvaliacaoController {
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@Autowired
	StarterService staterService;
	
	@Autowired
	ModuloService moduloService;
	
	@RequestMapping()
	public ModelAndView listarAvaliacao() {
		
		ModelAndView mv = new ModelAndView("avaliacao/listar");
		
		mv.addObject("listarAvaliacao", avaliacaoService.listarAvaliacao());
		mv.addObject("listaStarter", staterService.listarStarters());
		mv.addObject("listaModulo", moduloService.listarModulo());
		
		
		return mv;
		
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarAvaliacao(@Valid Avaliacao avaliacao,BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("avaliacao/form.html");
		
		boolean novo = true;
		
		if (avaliacao.getId() !=null) {
			novo = false;
		}
		
		if(bindingResult.hasErrors()) {
			mv.addObject("avaliacao",avaliacao);
			return mv;
		}

		avaliacaoService.salvarAvaliacao(avaliacao);
		if(novo) {
			mv.addObject("avaliacao",new Avaliacao());
		}else {
			mv.addObject("avaliacao",avaliacao);
		}
		mv.addObject("mensagem", "Avaliação Salva Com Sucesso");
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "editar")
	public ModelAndView novaAvaliacao(@RequestParam(required = false) Long id) {

		ModelAndView mv = new ModelAndView("avaliacao/form.html");

		Avaliacao avaliacao ;

		if (id == null) {
			avaliacao = new Avaliacao();

		} else {
			try {
				avaliacao = avaliacaoService.obterAvaliacao(id);
			} catch (Exception e) {
				avaliacao = new Avaliacao();
				mv.addObject("mensagem", e.getMessage());
			}
		}

		mv.addObject("avaliacao", avaliacao);
		mv.addObject("listaModulo", moduloService.listarModulo());
		mv.addObject("listaStarter", staterService.listarStarters());
		

		return mv;
	}
	
	
	
	@RequestMapping(path="excluir")
	public ModelAndView excluirAvaliacao(@RequestParam Long id , RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/avaliacao");
		
		try {
			
			
			
			avaliacaoService.excluirAvaliacao(id);
			redirectAttributes.addFlashAttribute("mensagem", "Avaliação Excluída com Sucesso");
			
		}catch(Exception e){
			
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
			
		}

		return mv;
	}

}



