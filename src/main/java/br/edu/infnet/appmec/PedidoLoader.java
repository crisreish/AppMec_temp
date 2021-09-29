package br.edu.infnet.appmec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmec.model.domain.Caldeira;
import br.edu.infnet.appmec.model.domain.Condensador;
import br.edu.infnet.appmec.model.domain.Pedido;
import br.edu.infnet.appmec.model.domain.Equipamento;
import br.edu.infnet.appmec.model.domain.Solicitante;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.service.PedidoService;

@Component
@Order(4)
public class PedidoLoader implements ApplicationRunner {

    @Autowired
    private PedidoService pedidoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(1);

        Solicitante solicitante = new Solicitante();
        solicitante.setId(1);

        Caldeira b1 = new Caldeira();
        b1.setId(1);

        Condensador c1 = new Condensador();
        c1.setId(2);

        List<Equipamento> equipamento = new ArrayList<Equipamento>();
        equipamento.add(b1);
        equipamento.add(c1);

        Pedido pedido = new Pedido();
        pedido.setDescricao("Meu pedido");
        pedido.setEquipamento(equipamento);
        pedido.setSolicitante(solicitante);
        pedido.setUsuario(usuario);

        pedidoService.incluir(pedido);
    }
}