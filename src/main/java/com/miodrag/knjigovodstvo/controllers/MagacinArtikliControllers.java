package com.miodrag.knjigovodstvo.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miodrag.knjigovodstvo.entities.MagacinArtikli;
import com.miodrag.knjigovodstvo.repos.MagacinArtikliRepository;
import com.miodrag.knjigovodstvo.service.MagacinArtikliService;

@Controller
public class MagacinArtikliControllers {
	
	@Autowired
	MagacinArtikliService magacinArtikliService;
	
	
	@Autowired
	MagacinArtikliRepository magacinArtikliRepository;
	
	@Autowired
	ServletContext scc;
	
	
	@RequestMapping("/createMagacinArtikli")
	public String showCreateMagacinArtikli() {
		return "createMagacinArtikli";
	}
	
	@RequestMapping("/saveMagacinArtikli")
	public	 String saveMagacinArtikli(@ModelAttribute("MagacinArtikli") MagacinArtikli MagacinArtikli, ModelMap modelMap) {
		 MagacinArtikli magacinArtikliSaved = magacinArtikliService.saveMagacinArtikli(MagacinArtikli);
		 
	//	 List<Object> data = new ArrayList<Object>();
	//	 data.add(MagacinArtikli);
		return "showMagacinArtikliunos";
	
	
	}	
	

	@RequestMapping("/displaytabelasviMagacinArtikli")
	public String magacinArtiklis(ModelMap  modelMap) {
		
	
		List<MagacinArtikli>   listaMagacinArtiklis = magacinArtikliService.getAllMagacinArtikli()	;					//service.getAllListaNaloga();

		
		modelMap.addAttribute("listaMagacinArtiklis",listaMagacinArtiklis  );  //new ArrayList<ListaNaloga>(listaNalogas) 
		return "displaytabelasviMagacinArtikli";
	}	
	
	@RequestMapping("deleteMagacinArtikli")
	public String deleteMagacinArtikli(@RequestParam("id") int id, ModelMap modelMap) {
		
		MagacinArtikli magacinArtikli= new MagacinArtikli();
		magacinArtikli.setId(id);
		magacinArtikliService.deleteMagacinArtikli(magacinArtikli);
		List<MagacinArtikli> sviMagacinArtikli = magacinArtikliService.getAllMagacinArtikli();
		modelMap.addAttribute("saviMagacinArtikli", sviMagacinArtikli);
		return "displaytabelasviMagacinArtikli";	
	}
	
	@RequestMapping("/updateMagacinArtikli")
	public String updateMagacinArtikli(@ModelAttribute("MagacinArtikli") MagacinArtikli magacinArtikli, ModelMap modelMap) {
		

		magacinArtikliService.updateMagacinArtikli(magacinArtikli);
   
		
		List<MagacinArtikli> sviMagacinArtikli = magacinArtikliService.getAllMagacinArtikli();
		modelMap.addAttribute("sviMagacinArtikli", sviMagacinArtikli);
		
		return  "displaytabelasviMagacinArtikli";
		
		}
	
}
