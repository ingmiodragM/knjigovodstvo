package com.miodrag.knjigovodstvo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miodrag.knjigovodstvo.entities.MagacinArtikli;

public interface MagacinArtikliRepository extends JpaRepository<MagacinArtikli, Integer> {

	@Query(nativeQuery = true, value ="SELECT * FROM magacin_artikli WHERE sifra_artikla =?1")
	MagacinArtikli findMagacinArtiklibysifra_artikla(String sifra_Artikla);

}
