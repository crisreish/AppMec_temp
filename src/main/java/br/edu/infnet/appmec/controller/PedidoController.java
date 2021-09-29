package br.edu.infnet.appmec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmec.model.domain.Pedido;
import br.edu.infnet.appmec.model.domain.Equipamento;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.service.PedidoService;
import br.edu.infnet.appmec.model.service.EquipamentoService;
import br.edu.infnet.appmec.model.service.SolicitanteService;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private SolicitanteService solicitanteService;
    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping(value = "/pedido")
    public String tela(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("solicitantes", solicitanteService.obterLista(usuario));

        model.addAttribute("equipamentos", equipamentoService.obterLista(usuario));

        return "pedido/cadastro";
    }

    @GetMapping(value = "/pedido/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("lista", pedidoService.obterLista(usuario));

        return "pedido/lista";
    }

    @PostMapping(value = "/pedido/incluir")
    public String incluir(Model model, Pedido pedido, @RequestParam String[] equipamentosId, @SessionAttribute("user") Usuario usuario) {

        List<Equipamento> equipamento = new ArrayList<>();

        for(String id : equipamentosId) {
            equipamento.add(equipamentoService.obterPorId(Integer.valueOf(id)));
        }

        pedido.setEquipamento(equipamento);

        pedido.setUsuarios(usuario);

        pedidoService.incluir(pedido);

        String mensagem = "O pedido "+ pedido.getDescricao() +" foi cadastrado com sucesso!!!";

        model.addAttribute("msg", mensagem);

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/pedido/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Pedido pedido = pedidoService.obterPorId(id);

        pedidoService.excluir(id);

        String mensagem = "O pedido "+ pedido.getDescricao() +" foi removido com sucesso!!!";

        model.addAttribute("msg", mensagem);

        return telaLista(model, usuario);
    }
}