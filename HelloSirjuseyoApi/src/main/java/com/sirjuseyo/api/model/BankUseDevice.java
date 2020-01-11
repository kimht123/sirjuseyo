package com.sirjuseyo.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bankUseDevice")
public class BankUseDevice {
	private static final long serialVersionUID=1L;
	
	@Id
	private Integer yyyy;
	
	private Double rate;

	private Double phone;
	
	private Double desktop;
	
	private Double notebook;

	private Double other;

	private Double pad;

	public Integer getYyyy() {
		return yyyy;
	}

	public void setYyyy(Integer yyyy) {
		this.yyyy = yyyy;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getPhone() {
		return phone;
	}

	public void setPhone(Double phone) {
		this.phone = phone;
	}

	public Double getDesktop() {
		return desktop;
	}

	public void setDesktop(Double desktop) {
		this.desktop = desktop;
	}

	public Double getNotebook() {
		return notebook;
	}

	public void setNotebook(Double notebook) {
		this.notebook = notebook;
	}

	public Double getOther() {
		return other;
	}

	public void setOther(Double other) {
		this.other = other;
	}

	public Double getPad() {
		return pad;
	}

	public void setPad(Double pad) {
		this.pad = pad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BankUseDevice(Integer yyyy, Double rate, Double phone, Double desktop, Double notebook, Double other,
			Double pad) {
		super();
		this.yyyy = yyyy;
		this.rate = rate;
		this.phone = phone;
		this.desktop = desktop;
		this.notebook = notebook;
		this.other = other;
		this.pad = pad;
	}

	public BankUseDevice() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
