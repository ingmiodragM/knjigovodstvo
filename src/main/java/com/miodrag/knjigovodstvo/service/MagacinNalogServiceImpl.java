package com.miodrag.knjigovodstvo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miodrag.knjigovodstvo.entities.MagacinNalog;
import com.miodrag.knjigovodstvo.repos.MagacinNalogRepository;

@Service
public class MagacinNalogServiceImpl implements MagacinNalogService {
	
	@Autowired
	private MagacinNalogRepository  repository;

	@Override
	public MagacinNalog saveMagacinNalog(MagacinNalog magacinNalog) {
		
		repository.save(magacinNalog);
		return null;
	}

	@Override
	public MagacinNalog updateMagacinNalog(MagacinNalog magacinNalog) {

		repository.save(magacinNalog);
		return null;
	}

	@Override
	public void deleteMagacinNalog(MagacinNalog magacinNalog) {
		
		repository.delete(magacinNalog);

	}

	@Override
	public MagacinNalog getMagacinNalogById(int id) {

		
		
		return  repository.getById(id);
	}

	@Override
	public List<MagacinNalog> getAllMagacinNalog() {
		
		return (List<MagacinNalog>)repository.findAll();
	}

	@Override
	public List<MagacinNalog> findMagacinNalogbybr_naloga(Integer brn) {
		
		return (List<MagacinNalog>)repository.findMagacinNalogbybr_naloga(brn);
	}

}
