package andre.guenther.desafiocidades.rest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import andre.guenther.desafiocidades.entities.Cidade;
import andre.guenther.desafiocidades.repository.CidadeRepository;

@Path("/upload")
public class Upload {
	
	@EJB
	private CidadeRepository repository;

	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadFile(MultipartFormDataInput input ) {
		try {
			Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
			List<InputPart> inputParts = uploadForm.get("file");

			BufferedReader br = null;
			String linha = "";
			List<String[]> linhas = new ArrayList<>();
			for (InputPart inputPart : inputParts) {		        
		        try {
		        
		            InputStream inputStream = inputPart.getBody(InputStream.class,null);
		            br = new BufferedReader(new InputStreamReader(inputStream));
		            int contadorlinha = 0;
		            while ((linha = br.readLine()) != null) {                
		               
		                if (contadorlinha == 0) {
		                	contadorlinha++;
		                	continue;		                	
		                } 
		                
		                String[] valoresEntreVirgulas = linha.split(",");	     
		                linhas.add(valoresEntreVirgulas);
		                
		                Cidade cidade = new Cidade();
		                cidade.setIbgeid(Long.parseLong(valoresEntreVirgulas[0]));
		                cidade.setUf(valoresEntreVirgulas[1]);
		                cidade.setName(valoresEntreVirgulas[2]);
		                cidade.setCapital(Boolean.parseBoolean(valoresEntreVirgulas[3]));
		                cidade.setLongitude(Double.parseDouble(valoresEntreVirgulas[4]));
		                cidade.setLatitude(Double.parseDouble(valoresEntreVirgulas[5]));
		                cidade.setNoaccents(valoresEntreVirgulas[6]);
		                cidade.setAlternative(valoresEntreVirgulas[7]);
		                cidade.setMicroregion(valoresEntreVirgulas[8]);
		                cidade.setMesoregion(valoresEntreVirgulas[9]);
		                
		                repository.salvar(cidade);

		            }
		            br.close();
		        }catch(Exception e) {
		            e.printStackTrace();
		        }	
			}
		        return Response.ok(linhas).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.serverError().build();
	}
	

}
