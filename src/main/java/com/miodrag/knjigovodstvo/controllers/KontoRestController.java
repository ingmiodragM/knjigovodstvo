package com.miodrag.knjigovodstvo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miodrag.knjigovodstvo.entities.Konto;
import com.miodrag.knjigovodstvo.repos.KontoRepository;

@RestController
public class KontoRestController {
	
	@Autowired
	KontoRepository repository;
	
	@GetMapping("Konto/{number}")
	public Konto getKonto(@PathVariable("number") String numb) {

		return repository.findKontobysnumber(numb);
	}
	
	@RequestMapping("/SvaKonta")
//	@GetMapping
	public List<Konto> getSvaKonta(){

		return repository.findAll();
	}

}
