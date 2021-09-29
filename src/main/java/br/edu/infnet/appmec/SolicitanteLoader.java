package br.edu.infnet.appmec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmec.model.domain.Solicitante;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.service.SolicitanteService;

@Component
@Order(2)
public class SolicitanteLoader implements ApplicationRunner {

    @Autowired
    private SolicitanteService solicitanteService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(1);

        Solicitante solicitante = new Solicitante("Usuario Teste", "teste@teste.com", "amrj222");
        solicitante.setUsuario(usuario);

        solicitanteService.incluir(solicitante);
    }
}
