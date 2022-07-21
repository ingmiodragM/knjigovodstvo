package com.miodrag.knjigovodstvo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miodrag.knjigovodstvo.entities.MagacinArtikli;
import com.miodrag.knjigovodstvo.repos.MagacinArtikliRepository;

@Service
public class MagacinArtikliServiceImpl implements MagacinArtikliService {
	
	@Autowired
	private MagacinArtikliRepository  repository;

	@Override
	public MagacinArtikli saveMagacinArtikli(MagacinArtikli MagacinArtikli) {
		
		repository.save(MagacinArtikli);
		return null;
	}

	@Override
	public MagacinArtikli updateMagacinArtikli(MagacinArtikli MagacinArtikli) {
		
		repository.save(MagacinArtikli);
		return null;
	}

	@Override
	public void deleteMagacinArtikli(MagacinArtikli magacinArtikli) {
		
		repository.delete(magacinArtikli);

	}

	@Override
	public MagacinArtikli getMagacinArtikliById(int id) {
		
	return	repository.getById(id)	;
	
	}

	@Override
	public List<MagacinArtikli> getAllMagacinArtikli() {
		
		return (List<MagacinArtikli>) repository.findAll();
	}

	@Override
	public MagacinArtikli findMagacinArtiklibysifra_artikla(String sifra_Artikla) {
		// TODO Auto-generated method stub
		return (MagacinArtikli) repository.findMagacinArtiklibysifra_artikla(sifra_Artikla);
	}

}
