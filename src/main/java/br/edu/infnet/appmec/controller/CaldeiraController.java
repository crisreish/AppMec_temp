package br.edu.infnet.appmec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.domain.Caldeira;
import br.edu.infnet.appmec.model.service.CaldeiraService;

@Controller
public class CaldeiraController {

	@Autowired
	private CaldeiraService caldeiraService;

	@GetMapping(value = "/caldeira/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("caldeira", caldeiraService.obterLista(usuario));

		return "caldeira/lista";
	}

	@GetMapping(value = "/caldeira")
	public String telaCadastro() {
		return "caldeira/cadastro";
	}

	@PostMapping(value = "/caldeira/incluir")
	public String incluir(Model model, Caldeira caldeira, @SessionAttribute("user") Usuario usuario) {

		caldeira.setUsuario(usuario);

		caldeiraService.incluir(caldeira);

		model.addAttribute("msg", "Caldeira " + caldeira.getDescricao() + " Equipamento cadastrado com sucesso!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/caldeira/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Caldeira caldeira = caldeiraService.obterPorId(id);

		String mensagem = null;
		try {
			caldeiraService.excluir(id);
			mensagem = "A caldeira " + caldeira.getDescricao() + " foi removida com sucesso!";
		} catch (Exception e) {
			mensagem = "Foi impossível realizar a exclusão da caldeira "+ caldeira.getDescricao();
		}
		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}

}