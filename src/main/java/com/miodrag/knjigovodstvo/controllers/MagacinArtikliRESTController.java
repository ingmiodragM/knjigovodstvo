package com.miodrag.knjigovodstvo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miodrag.knjigovodstvo.entities.MagacinArtikli;
import com.miodrag.knjigovodstvo.repos.MagacinArtikliRepository;

@RestController
public class MagacinArtikliRESTController {

	@Autowired
	MagacinArtikliRepository repository;
	
	
	@GetMapping("MagacinArtikli/{sifra_artikla}")
	public MagacinArtikli getKonto(@PathVariable("sifra_artikla") String sifra_artikla) {

		return repository.findMagacinArtiklibysifra_artikla(sifra_artikla);
	}
	


	@RequestMapping("/SviMagacinArtikli")
	@GetMapping
	public List<MagacinArtikli> getSviMagacinArtikli(){

		return repository.findAll();
	}	
	
}
