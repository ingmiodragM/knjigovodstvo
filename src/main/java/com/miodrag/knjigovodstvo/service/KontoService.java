package com.miodrag.knjigovodstvo.service;

import java.util.List;

import com.miodrag.knjigovodstvo.entities.Konto;

public interface KontoService {
	
	Konto saveKonto(Konto konto);

	Konto updateKonto(Konto konto);

	void deleteKonto(Konto konto);

	Konto getKontoById(int id);

	List<Konto> getAllKonto();
	
	Konto findKontobysnumber(String br);

}
