package cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t01.n01.model.services.SucursalService;

@Controller
public class SucursalController {

	@Autowired
	private SucursalService sServ;

	@GetMapping({ "/mostrarSucursals", "/", "/list" })
	public ModelAndView mostrarSucursals() {
		ModelAndView mav = new ModelAndView("list-sucursals");
		List<SucursalDTO> list = sServ.mostrarTot();
		mav.addObject("sucursalsDTO", list);
		return mav;
	}

	@GetMapping("/addSucursalForm")
	public ModelAndView afegirSucursalForm() {
		ModelAndView mav = new ModelAndView("add-sucursal-form");
		SucursalDTO sucursal = new SucursalDTO();
		mav.addObject("sucursal", sucursal);
		return mav;
	}

	@PostMapping("/saveSucursal")
	public String guardarSucursal(@ModelAttribute SucursalDTO sDTO) {
		sServ.guardar(sDTO);
		return "redirect:/list";
	}

	@GetMapping("/showUpdateForm")
	public ModelAndView mostrarUpdateForm(@RequestParam Integer pk_SucursalID) {
		ModelAndView mav = new ModelAndView("add-sucursal-form");
		SucursalDTO sDTO = sServ.buscarPerId(pk_SucursalID);
		mav.addObject("sucursal", sDTO);

		return mav;
	}

	@GetMapping("/deleteSucursal")
	public String eliminarSucursal(@RequestParam Integer pk_SucursalID) {
		sServ.eliminarPerId(pk_SucursalID);
		return "redirect:/list";

	}
	
	
	@GetMapping("/searchSucursalForm")
	public ModelAndView buscarSucursalForm() {
		ModelAndView mav = new ModelAndView("search-sucursal-form");
		SucursalDTO sucursal = new SucursalDTO();
		mav.addObject("sucursal", sucursal);
		return mav;	
	}
	
	@GetMapping("/searchSucursal")
	public ModelAndView searchSucursal(@RequestParam String nomSucursal) {
		ModelAndView mav = new ModelAndView("show-sucursal");
		List<SucursalDTO> list = sServ.buscarPerNom(nomSucursal);
		mav.addObject("sucursalsDTO", list);
		return mav;
	}
	
	

}
