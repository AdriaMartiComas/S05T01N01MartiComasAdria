package cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "sucursals")
public class Sucursal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pk_SucursalID;

	private String nomSucursal;

	private String paisSucursal;

	public Sucursal() {
	}

	public Sucursal(Integer pk_SucursalID, String nomSucursal, String paisSucursal) {
		this.pk_SucursalID = pk_SucursalID;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	public Integer getPk_SucursalID() {
		return pk_SucursalID;
	}

}
