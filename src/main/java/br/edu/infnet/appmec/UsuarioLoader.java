package br.edu.infnet.appmec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmec.model.domain.Oficina;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Oficina oficina= new Oficina();
        oficina.setUnidade("amrj22");
        oficina.setSetor("amrj22.222");


        Usuario usuario = new Usuario();
        usuario.setNome("Cristiane Andrade");
        usuario.setEmail("cristiane.andrade@al.infnet.edu.br");
        usuario.setSenha("fb053089");
        usuario.setAdmin(true);
        usuario.setOficina(oficina);

        usuarioService.incluir(usuario);
    }
}
