package br.com.uniride.model;

import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Ride {

	@Id
	@GeneratedValue
	private int id;

    @Column(columnDefinition = "ENUM('open', 'proggress', 'finished') default 'open'")
	private String status;

	@ManyToOne
	private User driver;

	@ManyToOne
	private Car car;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private int traveler_quantity;

	@Column(nullable = false)
	private Boolean only_woman;

	@Column(nullable = true)
	private Double price;
	
	@Column(nullable = true)
	private String description;

	@OneToMany
	private List<User> travelers;

	@Column(nullable = false)
	private Calendar start_at;

	@Column(nullable = false)
	private Calendar end_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getDriver() {
		return driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTraveler_quantity() {
		return traveler_quantity;
	}

	public void setTraveler_quantity(int traveler_quantity) {
		this.traveler_quantity = traveler_quantity;
	}

	public Boolean getOnly_woman() {
		return only_woman;
	}

	public void setOnly_woman(Boolean only_woman) {
		this.only_woman = only_woman;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getTravelers() {
		return travelers;
	}

	public void setTravelers(List<User> travelers) {
		this.travelers = travelers;
	}

	public Calendar getStart_at() {
		return start_at;
	}

	public void setStart_at(Calendar start_at) {
		this.start_at = start_at;
	}

	public Calendar getEnd_at() {
		return end_at;
	}

	public void setEnd_at(Calendar end_at) {
		this.end_at = end_at;
	}

}
