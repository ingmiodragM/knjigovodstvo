package com.miodrag.knjigovodstvo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.miodrag.knjigovodstvo.entities.ListaNaloga;

public interface ListaNalogaRepository extends JpaRepository<ListaNaloga, Integer> {
	
	@Query(nativeQuery = true, value ="SELECT * FROM lista_naloga WHERE br_naloga =?1")
	List<ListaNaloga> findlistu_NalogabyBrNaloga(int brn);

}
