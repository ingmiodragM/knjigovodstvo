package com.miodrag.knjigovodstvo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "konto")
public class Konto {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "number")
	private String number;
	@Column(name = "name")
	private String name;
	@Column(name = "sadrzaj")
	private String sadrzaj;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	@Override
	public String toString() {
		return "Konto [id=" + id + ", number=" + number + ", name=" + name + ", sadrzaj=" + sadrzaj + "]";
	}

}
