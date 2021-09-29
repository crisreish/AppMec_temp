package br.edu.infnet.appmec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appmec.model.domain.Caldeira;
import br.edu.infnet.appmec.model.domain.Condensador;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.service.CaldeiraService;
import br.edu.infnet.appmec.model.service.CondensadorService;

@Component
@Order(3)
public class EquipamentoLoader implements ApplicationRunner {

    @Autowired
    private CaldeiraService caldeiraService;
    @Autowired
    private CondensadorService condensadorService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setId(1);

        Caldeira b1 = new Caldeira("Caldeira Inox", 100, true);
        b1.setDescricao("vapor superaquecido");
        b1.setNumserie(5025);
        b1.setGarantia(true);
        b1.setUsuario(usuario);

        caldeiraService.incluir(b1);

        Condensador c1 = new Condensador("Condensador Inox", 150F, true);
        c1.setGarantia(false);
        c1.setDescricao("vapor superaquecido");
        c1.setNumserie(6045);

        condensadorService.incluir(c1);
    }
}
