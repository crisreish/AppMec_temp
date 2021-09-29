package br.edu.infnet.appmec.model.repository;

import java.util.List;

import br.edu.infnet.appmec.model.domain.Condensador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondensadorRepository extends CrudRepository<Condensador, Integer> {

	@Query("from Condensador b where b.usuario.id = :userId")
	public List<Condensador> obterLista(Integer userId);
}
