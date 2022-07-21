package com.miodrag.knjigovodstvo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "magacin_artikli")
public class MagacinArtikli {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "opis")
	private String opis;
	@Column(name = "sifra_artikla")
	private String sifra_artikla;
	@Column(name = "jedinica_mere")
	private String jedinica_mere;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getSifra_artikla() {
		return sifra_artikla;
	}

	public void setSifra_artikla(String sifra_artikla) {
		this.sifra_artikla = sifra_artikla;
	}

	public String getJedinica_mere() {
		return jedinica_mere;
	}

	public void setJedinica_mere(String jedinica_mere) {
		this.jedinica_mere = jedinica_mere;
	}

	@Override
	public String toString() {
		return "MagacinArtikli [id=" + id + ", opis=" + opis + ", sifra_artikla=" + sifra_artikla + ", jedinica_mere="
				+ jedinica_mere + "]";
	}

}
