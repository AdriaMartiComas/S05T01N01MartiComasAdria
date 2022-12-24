package cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.dto.SucursalDTO;

public interface SucursalService {

	public static SucursalDTO convertToDTO(Sucursal sucursal){
		SucursalDTO sDTO = new SucursalDTO();
		
		sDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
		sDTO.setNomSucursal(sucursal.getNomSucursal());
		sDTO.setPaisSucursal(sucursal.getPaisSucursal());
		sDTO.setTipusSucursal("Fora de la UE");
		
		String paisos[] = SucursalDTO.getPaisos();
		int length = paisos.length;
		
		for(int i = 0; i<length; i++) {
			if(paisos[i].equalsIgnoreCase(sDTO.getPaisSucursal())) {
				sDTO.setTipusSucursal("UE");
			} 
		}
		
		return sDTO;
	}
	
	public List<SucursalDTO> mostrarTot();
	
	public void guardar(SucursalDTO sDTO);

	public SucursalDTO buscarPerId(Integer id);
	
	public List<SucursalDTO> buscarPerNom(String nom);
	
	public void eliminarPerId(Integer id);

}
