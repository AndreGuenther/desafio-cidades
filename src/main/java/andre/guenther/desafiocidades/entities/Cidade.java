package andre.guenther.desafiocidades.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name="Cidade.consultarCidadesCapitais",
                query="SELECT c FROM Cidade c WHERE c.capital = true order by c.name"),
    
    @NamedQuery(name="Cidade.qtdCidadeEstado",
    query="SELECT c.uf, count(c.name) as total from Cidade c group by c.uf order by total ")    
    
}) 

public class Cidade {
	@Column
	@Id
	private Long ibgeid;
	@Column
	private String uf;
	@Column
	private String name;
	@Column
	private Boolean capital;
	@Column
	private Double longitude;
	@Column
	private Double latitude;
	@Column
	private String noaccents;
	@Column
	private String alternative;
	@Column
	private String microregion;
	@Column
	private String mesoregion;
	public Long getIbgeid() {
		return ibgeid;
	}
	public void setIbgeid(Long ibgeid) {
		this.ibgeid = ibgeid;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getCapital() {
		return capital;
	}
	public void setCapital(Boolean capital) {
		this.capital = capital;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getNoaccents() {
		return noaccents;
	}
	public void setNoaccents(String noaccents) {
		this.noaccents = noaccents;
	}
	public String getAlternative() {
		return alternative;
	}
	public void setAlternative(String alternative) {
		this.alternative = alternative;
	}
	public String getMicroregion() {
		return microregion;
	}
	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}
	public String getMesoregion() {
		return mesoregion;
	}
	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}
	
	
}

