package br.edu.infnet.appmec.model.service;

import java.util.List;

import br.edu.infnet.appmec.model.domain.Condensador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.repository.CondensadorRepository;

@Service
public class CondensadorService {
	
	@Autowired
	private CondensadorRepository condensadorRepository;

	public List<Condensador> obterLista(Usuario usuario){
		return condensadorRepository.obterLista(usuario.getId());
	}
	public List<Condensador> obterLista(){
		return (List<Condensador>) condensadorRepository.findAll();
	}
	
	public void incluir(Condensador condensador) {
		condensadorRepository.save(condensador);
	}
	
	public void excluir(Integer id) {
		condensadorRepository.deleteById(id);
	}
	
	public Condensador obterPorId(Integer id) {
		return condensadorRepository.findById(id).orElse(null);
	}
}