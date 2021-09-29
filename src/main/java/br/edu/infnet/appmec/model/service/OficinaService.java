package br.edu.infnet.appmec.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appmec.clients.IOficinaClient;
import br.edu.infnet.appmec.model.domain.Oficina;

@Service
public class OficinaService {
	
	@Autowired
	private IOficinaClient oficinaClient;

	public Oficina obterUnidade(String unidade) {

		OficinaService unidadeClient = null;
		return unidadeClient.obterUnidade(unidade);
	}
}