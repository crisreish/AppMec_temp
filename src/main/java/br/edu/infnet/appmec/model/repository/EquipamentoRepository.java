package br.edu.infnet.appmec.model.repository;

import java.util.List;

import br.edu.infnet.appmec.model.domain.Equipamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends CrudRepository<Equipamento, Integer> {

	@Query("from Equipamento e where e.usuario.id = :userId")
	public List<Equipamento> obterLista(Integer userId);
}
