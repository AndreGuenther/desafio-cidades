package andre.guenther.desafiocidades.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import andre.guenther.desafiocidades.entities.Cidade;
import andre.guenther.desafiocidades.repository.CidadeRepository;

@Path("/cidade")
public class CidadeRest {
	
	@EJB
	private CidadeRepository repository;
	
	@GET
	@Path("/capitais")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cidade> consultarCidadesCapitais() {
		
		return repository.consultarCidadesCapitais();
	}	

}
