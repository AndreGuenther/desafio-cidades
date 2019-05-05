package andre.guenther.desafiocidades.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	

	
	public List<Object[]> qtdCidadeEstado() {
		
		Query query = this.entityManager.createNamedQuery("Cidade.qtdCidadeEstado");
		return query.getResultList();

	}
	
	public Map<String, Object> qtdCidadeEstadoMaiorMenor() {
	
		Object[] maior = {"",Long.MIN_VALUE};
		Object[] menor= {"",Long.MAX_VALUE};
		
		for ( Object[] total: qtdCidadeEstado()) {
			long qtd = (Long) total[1];
			long qtdMaior = (Long) maior[1];
			long qtdMenor = (Long) menor[1];
			
			if (qtdMaior < qtd) {
				maior = total;
			}  
			if (qtdMenor > qtd) {
				menor =  total;
			}
		}

		Map<String, Object> resultMenor = new LinkedHashMap<>();
		
		resultMenor.put("uf", menor[0] );
		resultMenor.put("qtdCidades", menor[1] );
		
		Map<String, Object> resultMaior = new LinkedHashMap<>();
		
		resultMaior.put("uf", maior[0] );
		resultMaior.put("qtdCidades", maior[1] );
		
		
		Map<String, Object> resultGeral = new LinkedHashMap<>();
		resultGeral.put("menor", resultMenor);
		resultGeral.put("maior", resultMaior);
		
		return resultGeral;

	}
}
