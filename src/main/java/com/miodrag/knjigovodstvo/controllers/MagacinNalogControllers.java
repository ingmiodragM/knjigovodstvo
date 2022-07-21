package com.miodrag.knjigovodstvo.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miodrag.knjigovodstvo.entities.MagacinNalog;
import com.miodrag.knjigovodstvo.repos.MagacinNalogRepository;
import com.miodrag.knjigovodstvo.service.MagacinNalogService;

@Controller
public class MagacinNalogControllers {
	
	@Autowired
	MagacinNalogService magacinNalogService;
	
	@Autowired
	MagacinNalogRepository magacinNalogRepository;
	
	@Autowired
	ServletContext scc;
	

	@RequestMapping("/createMagacinNalog")
	public String showCreateMagacinNalog() {
		return "createMagacinNalog";
	}	
	

	@RequestMapping("/saveMagacinNalog")
	public	 String saveMagacinNalog(@ModelAttribute("MagacinNalog") MagacinNalog magacinNalog, ModelMap modelMap) {
		 MagacinNalog magacinNalogSaved = magacinNalogService.saveMagacinNalog(magacinNalog);
		 
	//	 List<Object> data = new ArrayList<Object>();
	//	 data.add(magacinNalog);
		return "createMagacinNalog";
	
	
	}	
	
	@RequestMapping("/displaytabelasviMagacinNalog")
	public String MagacinNalogs(ModelMap  modelMap) {
		
	
		List<MagacinNalog>   listaMagacinNalogs = magacinNalogService.getAllMagacinNalog()	;					//service.getAllListaNaloga();

		
		modelMap.addAttribute("listaMagacinNalogs",listaMagacinNalogs  );  //new ArrayList<ListaNaloga>(listaNalogas) 
		return "displaytabelasviMagacinNalog";
	}
	

	@RequestMapping("deleteMagacinNalog")
	public String deleteMagacinNalog(@RequestParam("id") int id, ModelMap modelMap) {
		
		MagacinNalog magacinNalog= new MagacinNalog();
		magacinNalog.setId(id);
		magacinNalogService.deleteMagacinNalog(magacinNalog);
		List<MagacinNalog> sviMagacinNalog = magacinNalogService.getAllMagacinNalog();
		modelMap.addAttribute("saviMagacinNalog", sviMagacinNalog);
		return "displaytabelasviMagacinNalog";	
	}	

	@RequestMapping("/updateMagacinNalog")
	public String updateMagacinNalog(@ModelAttribute("MagacinNalog") MagacinNalog magacinNalog, ModelMap modelMap) {
		

		magacinNalogService.updateMagacinNalog(magacinNalog);
   
		
		List<MagacinNalog> sviMagacinNalog = magacinNalogService.getAllMagacinNalog();
		modelMap.addAttribute("sviMagacinNalog", sviMagacinNalog);
		
		return  "displaytabelasviMagacinNalog";
		
		}
	@RequestMapping("/showUpdateMagacinNalog")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		
		System.out.println(id);
		MagacinNalog magacinNalog = magacinNalogService.getMagacinNalogById(id);
	//	magacinNalogService.saveMagacinNalog(magacinNalog);
		
		modelMap.addAttribute("magacinNalog", magacinNalog);
 	//	magacinNalogService.updateMagacinNalog(magacinNalog);
	//	System.out.println("saved");
		
		return "updateMagacinNalog";

	}
	
}
