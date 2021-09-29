package br.edu.infnet.appmec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.appmec.model.service.OficinaService;

@Controller
public class OficinaController {
	
	@Autowired
	private OficinaService oficinaService;

	@PostMapping(value = "/unidade")
	public String obterUnidade(Model model, @RequestParam String unidade) {
		
		model.addAttribute("oficina", oficinaService.obterUnidade(unidade));
		
		return "usuario/cadastro";
	}
}
