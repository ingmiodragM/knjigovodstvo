package com.miodrag.knjigovodstvo.service;

import java.util.List;

import com.miodrag.knjigovodstvo.entities.MagacinNalog;

public interface MagacinNalogService {
	
	MagacinNalog saveMagacinNalog(MagacinNalog magacinNalog);

	MagacinNalog updateMagacinNalog(MagacinNalog magacinNalog);

	void deleteMagacinNalog(MagacinNalog magacinNalog);

	MagacinNalog getMagacinNalogById(int id);

	List<MagacinNalog> getAllMagacinNalog();
	
	List<MagacinNalog> findMagacinNalogbybr_naloga(int brn);

}
