package com.miodrag.knjigovodstvo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miodrag.knjigovodstvo.entities.Konto;
import com.miodrag.knjigovodstvo.repos.KontoRepository;
import com.miodrag.knjigovodstvo.service.KontoService;


@Controller
public class KontoControllers {
	

	@Autowired
	KontoService kontoService;

	@Autowired
	ServletContext scc;
	
	@Autowired
	KontoRepository kontoRepository;

	

	
	@RequestMapping("/createKonto")
	public String showCreateKonto() {
		return "createKonto";
	}

	
	@RequestMapping("/saveKonto")
	public	 String saveKonto(@ModelAttribute("Konto") Konto konto, ModelMap modelMap) {
		 Konto kontoSaved = kontoService.saveKonto(konto);
		 
	//	 List<Object> data = new ArrayList<Object>();
	//	 data.add(konto);
		return "showKontounos";
	
	
	}
	
	@RequestMapping("/showUpdateKonto")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		
		System.out.println(id);
		Konto konto = kontoService.getKontoById(id);
		kontoService.saveKonto(konto);
		
		modelMap.addAttribute("Konto", konto);
		System.out.println(konto.getId());
		System.out.println(konto);     
		kontoService.updateKonto(konto);
		System.out.println("saved");
		
		return "updateKonto";

	}
	

	
	
	@RequestMapping("/displaytabelasvaKonta")
	public String kontos(ModelMap  modelMap) {
		
	
		List<Konto>   svaKonta = kontoService.getAllKonto()	;					//service.getAllListaNaloga();
		
		for (Konto konto: svaKonta) {
		    System.out.println(konto);
		}
		
		modelMap.addAttribute("svaKonta",svaKonta);  //new ArrayList<ListaNaloga>(listaNalogas) 
		return "displaytabelasvaKonta";
	}

	
	@RequestMapping("deleteKonto")
	public String deleteDnevnik(@RequestParam("id") int id, ModelMap modelMap) {
		
		Konto konto= new Konto();
		konto.setId(id);
		kontoService.deleteKonto(konto);
		List<Konto> svaKonta = kontoService.getAllKonto();
		modelMap.addAttribute("savaKonta", svaKonta);
		return "displaytabelasvaKonta";	
	}

	@RequestMapping("/updateKonto")
	public String updateKonto(@ModelAttribute("konto") Konto konto, ModelMap modelMap) {
		

		kontoService.updateKonto(konto);
   
		
		List<Konto> svaKonta = kontoService.getAllKonto();
		modelMap.addAttribute("svaKonta", svaKonta);
		
		return  "displaytabelasvaKonta";
		
		}	
	
}