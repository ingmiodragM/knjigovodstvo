package com.miodrag.knjigovodstvo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "magacin_nalog")
public class MagacinNalog {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "br_naloga")
	@NumberFormat(pattern = "##")
	private int br_naloga;

	@Column(name = "datum_naloga")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date datum_naloga;

	@Column(name = "sifra_artikla")
	private String sifra_artikla;

	@Column(name = "opis")
	private String opis;

	@Column(name = "jedinica_mere")
	private String jedinica_mere;

	@Column(name = "ulaz")
	@NumberFormat(pattern = "#.###,##")
	@JsonFormat(pattern = "#.###,##")
	private Double ulaz;

	@Column(name = "izlaz")
	@NumberFormat(pattern = "#.###,##")
	@JsonFormat(pattern = "#.###,##")
	private Double izlaz;

	@Column(name = "cena")
	@NumberFormat(pattern = "#.###,##")
	@JsonFormat(pattern = "#.###,##")
	private Double cena;

	@Column(name = "duguje")
	@NumberFormat(pattern = "#.###,##")
	@JsonFormat(pattern = "#.###,##")
	private Double duguje;

	@Column(name = "potrazuje")
	@NumberFormat(pattern = "#.###,##")
	@JsonFormat(pattern = "#.###,##")
	private Double potrazuje;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBr_naloga() {
		return br_naloga;
	}

	public void setBr_naloga(int br_naloga) {
		this.br_naloga = br_naloga;
	}

	public Date getDatum_naloga() {
		return datum_naloga;
	}

	public void setDatum_naloga(Date datum_naloga) {
		this.datum_naloga = datum_naloga;
	}

	public String getSifra_artikla() {
		return sifra_artikla;
	}

	public void setSifra_artikla(String sifra_artikla) {
		this.sifra_artikla = sifra_artikla;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getJedinica_mere() {
		return jedinica_mere;
	}

	public void setJedinica_mere(String jedinica_mere) {
		this.jedinica_mere = jedinica_mere;
	}

	public Double getUlaz() {
		return ulaz;
	}

	public void setUlaz(Double ulaz) {
		this.ulaz = ulaz;
	}

	public Double getIzlaz() {
		return izlaz;
	}

	public void setIzlaz(Double izlaz) {
		this.izlaz = izlaz;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Double getDuguje() {
		return duguje;
	}

	public void setDuguje(Double duguje) {
		this.duguje = duguje;
	}

	public Double getPotrazuje() {
		return potrazuje;
	}

	public void setPotrazuje(Double potrazuje) {
		this.potrazuje = potrazuje;
	}

	@Override
	public String toString() {
		return "MagacinNalog [id=" + id + ", br_naloga=" + br_naloga + ", datum_naloga=" + datum_naloga
				+ ", sifra_artikla=" + sifra_artikla + ", opis=" + opis + ", jedinica_mere=" + jedinica_mere + ", ulaz="
				+ ulaz + ", izlaz=" + izlaz + ", cena=" + cena + ", duguje=" + duguje + ", potrazuje=" + potrazuje
				+ "]";
	}

}
