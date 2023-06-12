package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
 
	@Id
	
	private Integer engineno;
	private String horsepower;
	private String carmodel;
	private String seaters;
	private String specifications;
	public Integer getEngineno() {
		return engineno;
	}
	public void setEngineno(Integer engineno) {
		this.engineno = engineno;
	}
	public String getHorsepower() {
		return horsepower;
	}
	public void setHorsepower(String horsepower) {
		this.horsepower = horsepower;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public String getSeaters() {
		return seaters;
	}
	public void setSeaters(String seaters) {
		this.seaters = seaters;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	@Override
	public String toString() {
		return "User [engineno=" + engineno + ", horsepower=" + horsepower + ", carmodel=" + carmodel + ", seaters="
				+ seaters + ", specifications=" + specifications + ", getEngineno()=" + getEngineno()
				+ ", getHorsepower()=" + getHorsepower() + ", getCarmodel()=" + getCarmodel() + ", getSeaters()="
				+ getSeaters() + ", getSpecifications()=" + getSpecifications() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
