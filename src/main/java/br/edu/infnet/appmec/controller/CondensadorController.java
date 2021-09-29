package br.edu.infnet.appmec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmec.model.domain.Condensador;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.service.CondensadorService;

@Controller
public class CondensadorController {
	
	@Autowired
	private CondensadorService condensadorService;

	@GetMapping(value = "/condensador/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("condensador", condensadorService.obterLista(usuario));
		
		return "condensador/lista";
	}	
	
	@GetMapping(value = "/condensador")
	public String telaCadastro() {
		return "condensador/cadastro";
	}
	
	@PostMapping(value = "/condensador/incluir")
	public String incluir(Model model, Condensador condensador, @SessionAttribute("user") Usuario usuario) {

		condensador.setUsuario(usuario);

		condensadorService.incluir(condensador);
		
		model.addAttribute("msg", "Comida " + condensador.getDescricao() + " Equipamento cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}
	
	@GetMapping(value = "/condensador/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Condensador condensador = condensadorService.obterPorId(id);

		String mensagem = null;
		try {
			condensadorService.excluir(id);
			mensagem = "O condensador " + condensador.getDescricao() + " foi removido com sucesso!";
		} catch (Exception e) {
			mensagem = "Foi impossível realizar a exclusão do condensador "+ condensador.getDescricao();
		}
		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}
}