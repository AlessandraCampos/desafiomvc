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

import com.desafioStarterMVC.gft.entities.Daily;
import com.desafioStarterMVC.gft.entities.Grupo;
import com.desafioStarterMVC.gft.entities.Starter;
import com.desafioStarterMVC.gft.services.DaillyStatusService;
import com.desafioStarterMVC.gft.services.DailyService;
import com.desafioStarterMVC.gft.services.StarterService;
import com.desafioStarterMVC.gft.services.GrupoService;
import com.desafioStarterMVC.gft.services.ModuloService;

@Controller
@RequestMapping("daily")
public class DailyController {

	@Autowired
	DailyService dailyService;

	@Autowired
	StarterService starterService;

	@Autowired
	DaillyStatusService dailyStatusService;
	
	@Autowired
	GrupoService grupoService;
	
	 @Autowired
     ModuloService moduloService;

	@Autowired
	@RequestMapping()
	public ModelAndView listarDailies() {

		List<Daily> dailies = dailyService.listarDaily();
		ModelAndView mv = new ModelAndView("dailies/listar.html");
		mv.addObject("listarDailies", dailies);
		mv.addObject("listarGrupos", grupoService.listarGrupo());

		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, path = "editar")
	public ModelAndView novaDaily(@RequestParam(required = false) Long id) {

		ModelAndView mv = new ModelAndView("dailies/form.html");

		Daily daily;

		if (id == null) {
			daily = new Daily();

		} else {
			try {
				daily = dailyService.obterDaily(id);
			} catch (Exception e) {
				daily = new Daily();
				mv.addObject("mensagem", e.getMessage());
			}
		}

		mv.addObject("daily", daily);
		mv.addObject("listaStarter", starterService.listarStarters());
		mv.addObject("listaModulo",moduloService.listarModulo());
		mv.addObject("listaStatus", dailyStatusService.dailiesStatus());
		

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarDaily(@Valid Daily daily, BindingResult bindingResult) {

		ModelAndView mv = new ModelAndView("dailies/form.html");

		boolean novo = true;

		if (daily.getId() != null) {
			novo = false;
		}
		if (bindingResult.hasErrors()) {
			mv.addObject("daily", daily);
			return mv;
		}

		dailyService.salvarDaily(daily);

		if (novo) {
			mv.addObject("daily", new Daily());
		} else {
			mv.addObject("daily", daily);
		}

		mv.addObject("mensagem", "Daily Salvo Com Sucesso");

		return mv;
	}
	
	
	@RequestMapping(path="excluir")
	public ModelAndView excluirDaily(@RequestParam Long id , RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/daily");
		
		try {
			dailyService.excluirDaily(id);
			     redirectAttributes.addFlashAttribute("mensagem", "Daily Excluída com Sucesso");
		    
			
		}catch(Exception e){
			
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir" + e.getMessage());
			
		}

		return mv;
	}
}
