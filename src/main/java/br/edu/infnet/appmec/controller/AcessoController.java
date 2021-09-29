package br.edu.infnet.appmec.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.service.CaldeiraService;
import br.edu.infnet.appmec.model.service.CondensadorService;
import br.edu.infnet.appmec.model.service.PedidoService;
import br.edu.infnet.appmec.model.service.SolicitanteService;
import br.edu.infnet.appmec.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class AcessoController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private SolicitanteService solicitanteService;

	@Autowired
	private CaldeiraService caldeiraService;

	@Autowired
	private CondensadorService condensadorService;

	@Autowired
	private PedidoService pedidoService;


	@GetMapping(value = "/app")
	public String telaApp(Model model) {
		return "index";
	}

	@GetMapping(value = "/")
	public String telaHome() {
		return "index";
	}

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();

		session.removeAttribute("user");

		return "redirect:/";
	}

	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {

		Usuario usuario = usuarioService.validar(email, senha);

		if(usuario != null) {

			model.addAttribute("user", usuario);

			return "index";
		} else {
			model.addAttribute("mensagem", "Autenticação inválida para o usuário "+ email +"!");

			return "login";
		}
	}
}