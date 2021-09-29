package br.edu.infnet.appmec.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.appmec.model.domain.Equipamento;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.repository.EquipamentoRepository;

@Service
public class EquipamentoService {
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;

	public List<Equipamento> obterLista(Usuario usuario){
		return (List<Equipamento>) equipamentoRepository.obterLista(usuario.getId());
	}
	public List<Equipamento> obterLista(){
		return (List<Equipamento>) equipamentoRepository.findAll();
	}

	public void excluir(Integer id) {
		equipamentoRepository.deleteById(id);
	}
	
	public Equipamento obterPorId(Integer id) {
		return equipamentoRepository.findById(id).orElse(null);
	}
}