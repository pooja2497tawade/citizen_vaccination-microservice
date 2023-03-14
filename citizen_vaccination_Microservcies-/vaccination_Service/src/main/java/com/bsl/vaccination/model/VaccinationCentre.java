package com.bsl.vaccination.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VaccinationCentre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vacctinationcentreId;
	private String vacctinationcentreName;
	private String vactinationcentreAddress;

	public VaccinationCentre() {

	}

	public int getVacctinationcentreId() {
		return vacctinationcentreId;
	}

	public void setVacctinationcentreId(int vacctinationcentreId) {
		this.vacctinationcentreId = vacctinationcentreId;
	}

	public String getVacctinationcentreName() {
		return vacctinationcentreName;
	}

	public void setVacctinationcentreName(String vacctinationcentreName) {
		this.vacctinationcentreName = vacctinationcentreName;
	}

	public String getVactinationcentreAddress() {
		return vactinationcentreAddress;
	}

	public void setVactinationcentreAddress(String vactinationcentreAddress) {
		this.vactinationcentreAddress = vactinationcentreAddress;
	}

}
