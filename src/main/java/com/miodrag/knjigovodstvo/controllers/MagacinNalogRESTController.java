package com.miodrag.knjigovodstvo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miodrag.knjigovodstvo.entities.MagacinNalog;
import com.miodrag.knjigovodstvo.repos.MagacinNalogRepository;

@RestController
public class MagacinNalogRESTController {
	
	@Autowired
	MagacinNalogRepository repository;
	
	@GetMapping("MagacinNalog/{br_naloga}")
	public MagacinNalog getbr_naloga(@PathVariable("br_naloga") Integer br_naloga) {

		return (MagacinNalog) repository.findMagacinNalogbybr_naloga(br_naloga);
	}	

	
	@RequestMapping("/SviMagacinNalog")
	@GetMapping
	public List<MagacinNalog> getSviMagacinNalog(){

		return repository.findAll();
	}
	

}
