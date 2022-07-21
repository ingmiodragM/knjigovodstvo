package com.miodrag.knjigovodstvo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.miodrag.knjigovodstvo.entities.ListaNaloga;
import com.miodrag.knjigovodstvo.repos.ListaNalogaRepository;

@Service
public class ListaNalogaServiceImpl implements ListaNalogaService {
	
	@Autowired
	private ListaNalogaRepository repository;

	@Override
	public ListaNaloga saveListaNaloga(ListaNaloga listaNaloga) {
		
		repository.save(listaNaloga);

		return null;
	}

	@Override
	public ListaNaloga updateListaNaloga(ListaNaloga listaNaloga) {
		
		repository.save(listaNaloga);

		return null;
	}

	@Override
	public void deleteListaNaloga(ListaNaloga listaNaloga) {
		
		repository.delete(listaNaloga);


	}

	@Override
	public ListaNaloga getListaNalogaById(int id) {
	
		return	repository.findById(id).get();
		

	}

	@Override
	public List<ListaNaloga> getAllListaNaloga() {

		return (List<ListaNaloga>) repository.findAll();	
		

	}

	@Override
	public List<ListaNaloga> findlistu_NalogabyBrNaloga(int brn) {

		return (List<ListaNaloga>) repository.findlistu_NalogabyBrNaloga(brn);
		
	}

}
