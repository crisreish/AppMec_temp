package br.edu.infnet.appmec.clients;

import br.edu.infnet.appmec.model.domain.Oficina;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "https://www.marinha.mil.br/amrj/divisao-de-oficinas-de-servicos-de%20-estaleiro-amrj-246-recertificacao-abnt/ws", name = "oficinaClient")
public interface IOficinaClient {

	@GetMapping(value = "/{unidade}/json")
	public Oficina obterUnidade(@PathVariable String unidade);
}