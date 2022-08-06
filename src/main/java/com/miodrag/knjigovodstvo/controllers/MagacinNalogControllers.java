package com.miodrag.knjigovodstvo.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miodrag.knjigovodstvo.entities.MagacinArtikli;
import com.miodrag.knjigovodstvo.entities.MagacinNalog;
import com.miodrag.knjigovodstvo.repos.MagacinArtikliRepository;
import com.miodrag.knjigovodstvo.repos.MagacinNalogRepository;
import com.miodrag.knjigovodstvo.service.MagacinArtikliService;
import com.miodrag.knjigovodstvo.service.MagacinNalogService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class MagacinNalogControllers {
	
	@Autowired
	MagacinNalogService magacinNalogService;
	
	@Autowired
	MagacinNalogRepository magacinNalogRepository;
	
	
	@Autowired
	MagacinArtikliService magacinArtikliService;
	
	
	@Autowired
	MagacinArtikliRepository magacinArtikliRepository;
	
	
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
		
		List<MagacinArtikli>   listaMagacinArtiklis = magacinArtikliService.getAllMagacinArtikli()	;
		modelMap.addAttribute("listaMagacinArtiklis",listaMagacinArtiklis  );		
	//	magacinNalogService.saveMagacinNalog(magacinNalog);
		
		modelMap.addAttribute("magacinNalog", magacinNalog);
 	//	magacinNalogService.updateMagacinNalog(magacinNalog);
	//	System.out.println("saved");
		
		return "updateMagacinNalog";

	}
	@RequestMapping(value="/printMagacinNalog", produces = MediaType.APPLICATION_PDF_VALUE)
	public	 ResponseEntity<byte[]> printMagacinNalog(@RequestParam("br_naloga") int brn, ModelMap modelMap) throws JRException , IOException
	
	
	{
		List<MagacinNalog> listanalogmagacinas = magacinNalogService.findMagacinNalogbybr_naloga(brn);
		
		 List<Object> data = new ArrayList<Object>();
		 
		 
		 for (final MagacinNalog listaMagacinNaloga: listanalogmagacinas) {
		 data.add(listaMagacinNaloga);
		 }
		 		System.out.println("staz 1");
				JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listanalogmagacinas);
				System.out.println("staz 2");
				
				Map<String, Object> parameters = new HashMap<>();
				
				JasperReport compileReport = JasperCompileManager
						.compileReport(new FileInputStream("src/main/resources/reports/PrintMagacinNalog.jrxml"));
				System.out.println("iskompajliran");
				
				JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters, beanCollectionDataSource);
				System.out.println("printanje");

				byte data1[] = JasperExportManager.exportReportToPdf(jasperPrint);
			//	System.err.println(data1);

				HttpHeaders headers = new HttpHeaders();
				headers.add("Content-Disposition", "inline; nalogreport.pdf");
				
				return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data1);		 

		 }
}
