package com.miodrag.knjigovodstvo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miodrag.knjigovodstvo.entities.ListaNaloga;
import com.miodrag.knjigovodstvo.repos.ListaNalogaRepository;

@RestController
@RequestMapping("/knjigovodstvos")
public class ListaNalogaRESTController {
	
	@Autowired
	ListaNalogaRepository   listaNalogaRepository;
	
	@GetMapping
	public List<ListaNaloga> getListanalogas(){

		return listaNalogaRepository.findAll();
	}

}
