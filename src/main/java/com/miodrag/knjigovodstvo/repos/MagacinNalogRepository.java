package com.miodrag.knjigovodstvo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miodrag.knjigovodstvo.entities.MagacinNalog;

public interface MagacinNalogRepository extends JpaRepository<MagacinNalog, Integer> {

	@Query(nativeQuery = true, value ="SELECT * FROM magacin+nalog WHERE br_naloga =?1")
	List<MagacinNalog> findMagacinNalogbybr_naloga(Integer brn);

}
