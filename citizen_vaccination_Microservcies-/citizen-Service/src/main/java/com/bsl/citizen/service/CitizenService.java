package com.bsl.citizen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bsl.citizen.model.Citizen;

@Service
public interface CitizenService {

	List<Citizen> addCitizen(Citizen c);

	List<Citizen> getAllCitizens();

	Citizen getCitizenById(int id);

	Citizen getCitizenByName(String name);

	List<Citizen> getCitizenByVaccinationCenterId(int vaccinationCenterId);

	List<Citizen> deleteCitizenById(int id);

	List<Citizen> updateCitizen(int id, Citizen c);

}
