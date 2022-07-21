package com.miodrag.knjigovodstvo.service;

import java.util.List;

import com.miodrag.knjigovodstvo.entities.ListaNaloga;



public interface ListaNalogaService  {
	
	ListaNaloga saveListaNaloga(ListaNaloga listaNaloga);

	ListaNaloga updateListaNaloga(ListaNaloga listaNaloga);

	void deleteListaNaloga(ListaNaloga listaNaloga);

	ListaNaloga getListaNalogaById(int id);

	List<ListaNaloga> getAllListaNaloga();
	
	List<ListaNaloga> findlistu_NalogabyBrNaloga(int brn);

}
