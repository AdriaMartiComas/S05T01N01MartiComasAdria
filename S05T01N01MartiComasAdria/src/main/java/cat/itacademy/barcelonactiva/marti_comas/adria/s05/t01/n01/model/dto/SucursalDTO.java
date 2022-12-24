package cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.dto;


import javax.persistence.Id;


public class SucursalDTO {


	@Id
	private Integer pk_SucursalID;

	private String nomSucursal;

	private String paisSucursal;

	private String tipusSucursal;

	static final String paisos[] = { "Espanya", "França", "Portugal", "Irlanda", "Italia", "Alemanya" };

	public SucursalDTO() {
	}

	public SucursalDTO(Integer pk_SucursalID, String nomSucursal, String paisSucursal, String tipusSucursal) {
		this.pk_SucursalID = pk_SucursalID;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.tipusSucursal = tipusSucursal;
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

	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String tipusSucursal) {
		this.tipusSucursal = tipusSucursal;
	}

	public Integer getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(Integer integer) {
		this.pk_SucursalID = integer;
	}

	public static String[] getPaisos() {
		return paisos;
	}

}
