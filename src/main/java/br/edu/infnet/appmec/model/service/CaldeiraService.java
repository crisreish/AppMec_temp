package br.edu.infnet.appmec.model.service;

import java.util.List;

import br.edu.infnet.appmec.model.domain.Caldeira;
import br.edu.infnet.appmec.model.domain.Condensador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.repository.CaldeiraRepository;

@Service
public class CaldeiraService {
	
	@Autowired
	private CaldeiraRepository caldeiraRepository;

	public List<Caldeira> obterLista(Usuario usuario){
		return caldeiraRepository.obterLista(usuario.getId());
	}
	public List<Caldeira> obterLista(){
		return (List<Caldeira>) caldeiraRepository.findAll();
	}

	public void incluir(Caldeira condensador) {
		caldeiraRepository.save(condensador);
	}

	public void excluir(Integer id) {
		caldeiraRepository.deleteById(id);
	}

	public Caldeira obterPorId(Integer id) {
		return caldeiraRepository.findById(id).orElse(null);
	}
}