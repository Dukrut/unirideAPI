package br.com.uniride.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String color;

	@Column(nullable = false)
	private String year;

	@Column(nullable = false)
	private String plate;

	@Column(nullable = false)
	private Integer bench;

	@ManyToOne
	private User user;

	@ManyToOne
	private Brand brand;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Integer getBench() {
		return bench;
	}

	public void setBench(Integer bench) {
		this.bench = bench;
	}
}
