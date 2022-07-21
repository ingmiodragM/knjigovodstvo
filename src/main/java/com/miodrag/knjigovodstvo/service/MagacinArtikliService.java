package com.miodrag.knjigovodstvo.service;

import java.util.List;

import com.miodrag.knjigovodstvo.entities.MagacinArtikli;

public interface MagacinArtikliService {
	
	MagacinArtikli saveMagacinArtikli(MagacinArtikli MagacinArtikli);

	MagacinArtikli updateMagacinArtikli(MagacinArtikli MagacinArtikli);

	void deleteMagacinArtikli(MagacinArtikli MagacinArtikli);

	MagacinArtikli getMagacinArtikliById(int id);

	List<MagacinArtikli> getAllMagacinArtikli();
	
	MagacinArtikli findMagacinArtiklibysifra_artikla(String sifra_Artikla);

}
