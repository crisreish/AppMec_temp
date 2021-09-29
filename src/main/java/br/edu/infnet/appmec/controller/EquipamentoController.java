package br.edu.infnet.appmec.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmec.model.domain.Equipamento;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.service.EquipamentoService;

@Controller
public class EquipamentoController {
	
	@Autowired
	private EquipamentoService equipamentoService;

	@GetMapping(value = "/equipamento/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("equipamento", equipamentoService.obterLista(usuario));
		
		return "equipamento/lista";
	}	

	@GetMapping(value = "/equipamento/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Equipamento equipamento = equipamentoService.obterPorId(id);
		
		equipamentoService.excluir(id);
		
		model.addAttribute("msg", "Equipamento" + equipamento.getDescricao() + "Equipamento removido com sucesso!");
		
		return telaLista(model, usuario);
	}
}