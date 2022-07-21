package com.miodrag.knjigovodstvo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miodrag.knjigovodstvo.entities.Konto;
import com.miodrag.knjigovodstvo.repos.KontoRepository;

@Service
public class KontoServiceImpl implements KontoService {
	
	@Autowired
	private KontoRepository repository;

	@Override
	public Konto saveKonto(Konto konto) {
		repository.save(konto);
		return null;
	}

	@Override
	public Konto updateKonto(Konto konto) {

		repository.save(konto);
		return null;
	}

	@Override
	public void deleteKonto(Konto konto) {

		repository.delete(konto);

	}

	@Override
	public Konto getKontoById(int id) {
		
		
		return (Konto) repository.findById(id).get();
	}

	@Override
	public List<Konto> getAllKonto() {
		
		return repository.findAll();
	}

	@Override
	public Konto findKontobysnumber(String br) {
		// TODO Auto-generated method stub
		return   repository.findKontobysnumber(br);
	}











}
