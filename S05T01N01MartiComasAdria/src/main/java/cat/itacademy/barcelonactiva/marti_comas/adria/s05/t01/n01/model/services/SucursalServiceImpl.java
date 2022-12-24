package cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {

	@Autowired
	private SucursalRepository sRepo;

	@Override
	@Transactional(readOnly = true)
	public List<SucursalDTO> mostrarTot() {
		List<Sucursal> sList = sRepo.findAll();
		List<SucursalDTO> sDTOlist = new ArrayList<SucursalDTO>();

		for (Sucursal sucursal : sList) {
			sDTOlist.add(SucursalService.convertToDTO(sucursal));
		}

		return sDTOlist;
	}

	@Override
	@Transactional
	public void guardar(SucursalDTO sDTO) {
		Sucursal s = new Sucursal(sDTO.getPk_SucursalID(), sDTO.getNomSucursal(), sDTO.getPaisSucursal());

		sRepo.save(s);
	}

	@Override
	public SucursalDTO buscarPerId(Integer id) {
		Sucursal s = sRepo.findById(id).get();
		return SucursalService.convertToDTO(s);
	}

	@Override
	public void eliminarPerId(Integer id) {
		sRepo.deleteById(id);

	}

	@Override
	public List<SucursalDTO> buscarPerNom(String nom) {
		List<Sucursal> listIn = sRepo.findAll();
		List<SucursalDTO> listOut = new ArrayList<SucursalDTO>();

		for (Sucursal sucursal : listIn) {
			if (sucursal.getNomSucursal().contains(nom)) {
				listOut.add(SucursalService.convertToDTO(sucursal));
			}
		}

		return listOut;

	}

}
