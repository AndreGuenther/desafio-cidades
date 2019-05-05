package andre.guenther.desafiocidades.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import andre.guenther.desafiocidades.entities.Cidade;

@Stateless
public class CidadeRepository {
	
	@PersistenceContext
	private EntityManager entityManager;	
	
	public void salvar(Cidade cidade) {
		this.entityManager.persist(cidade);
	}
	
	public List<Cidade> consultarCidadesCapitais() {
		
		Query query = this.entityManager.createNamedQuery("Cidade.consultarCidadesCapitais");
		return query.getResultList();
				
	}
}
