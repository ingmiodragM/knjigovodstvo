package com.miodrag.knjigovodstvo.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miodrag.knjigovodstvo.entities.Konto;
import com.miodrag.knjigovodstvo.entities.ListaNaloga;
import com.miodrag.knjigovodstvo.repos.KontoRepository;
import com.miodrag.knjigovodstvo.repos.ListaNalogaRepository;
import com.miodrag.knjigovodstvo.service.KontoService;
import com.miodrag.knjigovodstvo.service.ListaNalogaService;

import net.sf.jasperreports.engine.JRException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class ListaNalogaControllers {
	
	
	@Autowired
	ListaNalogaService service;
	
	@Autowired
	KontoService servicekonto;
	
	@Autowired
	ListaNalogaRepository repository;
	
	@Autowired
	KontoRepository repositorykonto;
	
	@Autowired
	ServletContext sc;

	@RequestMapping("/showNalog")
	public String showCreate() {
		return "createNalog";
	}
	@RequestMapping("/pripremacreatenalogtest")
	public String showCreate1() {
		return "pripremacreatenalogtest";
	}	
	
	@RequestMapping("/tableajax")
	public String loadajax() {
		return "tableajax";
	}
	@RequestMapping("/tableajaxtest2")
	public String loadajaxtest() {
		return "tableajaxtest2";
	}	

	
	@RequestMapping("/saveNalog")
	public	 String saveNalog(@ModelAttribute("ListaNaloga") ListaNaloga listaNaloga, ModelMap modelMap) throws JRException /*String saveNalog(@ModelAttribute("ListaNaloga") ListaNaloga listaNaloga, ModelMap modelMap) */, IOException
	
	{
		 
		 ListaNaloga listaNalogaSaved = service.saveListaNaloga(listaNaloga);
		 
		 List<Object> data = new ArrayList<Object>();
		 data.add(listaNaloga);
		return "createNalog";
	}
	

	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		
		System.out.println(id);
		ListaNaloga listaNaloga = service.getListaNalogaById(id);
	//	service.saveListaNaloga(listaNaloga);
		
		modelMap.addAttribute("listaNaloga", listaNaloga);


		List<Konto>   svaKonta = servicekonto.getAllKonto()	;
		modelMap.addAttribute("svaKonta",svaKonta);
	//	System.out.println(listaNaloga.getId());
	//	System.out.println(listaNaloga);     
		service.updateListaNaloga(listaNaloga);
	//	System.out.println("saved");
		
		return "updateListaNaloga";

	}
	
	@RequestMapping("/updateListaNaloga")
	public String updateDnevnik(@ModelAttribute("listaNaloga") ListaNaloga listaNaloga2, ModelMap modelMap) {
		
		System.out.println(listaNaloga2);
		service.updateListaNaloga(listaNaloga2);
		System.out.println(listaNaloga2);    
		
		List<ListaNaloga> listaNalogas = service.getAllListaNaloga();
		modelMap.addAttribute("listaNalogas", listaNalogas);  
		
	/*	for (ListaNaloga listaNaloga1: listaNalogas) {
		    System.out.println(listaNaloga1);
		}   */
		
		return "displayListaNaloga";
	//	return "createNalog";

	}
	
	@RequestMapping("/displayListaNaloga")
	public String listaNalogas(ModelMap  modelMap) {
		
//		List<ListaNaloga> listaNalogas = new ArrayList<ListaNaloga>();
		
	//	listaNalogas=new List<ListaNaloga>;	
		List<ListaNaloga>   listaNalogas = service.getAllListaNaloga();
/*		for (ListaNaloga listaNaloga1: listaNalogas) {
		    System.out.println(listaNalogas);
		}  */
		
		modelMap.addAttribute("listaNalogas",listaNalogas );  //new ArrayList<ListaNaloga>(listaNalogas) 
		return "displayListaNaloga";
	}
	
	@RequestMapping("deleteListaNaloga")
	public String deleteDnevnik(@RequestParam("id") int id, ModelMap modelMap) {
		
		ListaNaloga listaNaloga= new ListaNaloga();
		listaNaloga.setId(id);
		service.deleteListaNaloga(listaNaloga);
		List<ListaNaloga> listaNalogas = service.getAllListaNaloga();
		modelMap.addAttribute("listaNalogas", listaNalogas);
		return "displayListaNaloga";	
	}
	
	
	
	@RequestMapping(value="/print", produces = MediaType.APPLICATION_PDF_VALUE)
	public	 ResponseEntity<byte[]> printNalog(@RequestParam("br_naloga") int brn, ModelMap modelMap) throws JRException , IOException
	
	
	{
		List<ListaNaloga> listanalogas = service.findlistu_NalogabyBrNaloga(brn);
		
		 List<Object> data = new ArrayList<Object>();
		 
		 
		 for (final ListaNaloga listaNaloga: listanalogas) {
		 data.add(listaNaloga);
		 }
		 		System.out.println("staz 1");
				JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listanalogas);
				System.out.println("staz 2");
				Map<String, Object> parameters = new HashMap<>();
				
				JasperReport compileReport = JasperCompileManager
						.compileReport(new FileInputStream("src/main/resources/reports/test.jrxml"));
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
