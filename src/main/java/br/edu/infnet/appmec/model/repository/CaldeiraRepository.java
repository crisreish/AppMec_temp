package br.edu.infnet.appmec.model.repository;

import java.util.List;

import br.edu.infnet.appmec.model.domain.Caldeira;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaldeiraRepository extends CrudRepository<Caldeira, Integer> {

	@Query("from Caldeira a where a.usuario.id = :userId")
	public List<Caldeira> obterLista(Integer userId);
}