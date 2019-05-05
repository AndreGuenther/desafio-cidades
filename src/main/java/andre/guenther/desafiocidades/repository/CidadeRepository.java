package andre.guenther.desafiocidades.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import andre.guenther.desafiocidades.entities.Cidade;

@Stateless
public class CidadeRepository {
	
	@PersistenceContext
	private EntityManager entityManager;	
	
	public void salvar(Cidade cidade) {
		this.entityManager.persist(cidade);
	}
}
