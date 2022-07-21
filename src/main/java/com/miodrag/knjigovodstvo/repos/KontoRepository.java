package com.miodrag.knjigovodstvo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miodrag.knjigovodstvo.entities.Konto;

public interface KontoRepository extends JpaRepository<Konto, Integer> {

	@Query(nativeQuery = true, value ="SELECT * FROM konto WHERE number =?1")
	Konto findKontobysnumber(String br);

}
