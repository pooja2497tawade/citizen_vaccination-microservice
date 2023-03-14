package com.bsl.citizen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsl.citizen.model.Citizen;
import com.bsl.citizen.repository.CitizenRepository;


@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	CitizenRepository cr;

	@Override
	public List<Citizen> addCitizen(Citizen c) {

		cr.save(c);

		return cr.findAll();
	}

	@Override
	public List<Citizen> getAllCitizens() {

		return cr.findAll();
	}

	@Override
	public Citizen getCitizenById(int id) {

		Optional<Citizen> citizen = cr.findById(id);

		return citizen.get();
	}

	@Override
	public Citizen getCitizenByName(String name) {

		Optional<Citizen> citizen = cr.findByName(name);

		return citizen.get();
	}

	@Override
	public List<Citizen> getCitizenByVaccinationCenterId(int vaccinationCenterId) {
		List<Citizen> citizens = cr.findByVaccinationCenterId(vaccinationCenterId);

		return citizens;
	}

	@Override
	public List<Citizen> deleteCitizenById(int id) {

		cr.deleteById(id);

		return cr.findAll();
	}

	@Override
	public List<Citizen> updateCitizen(int id, Citizen c) {

		Optional<Citizen> citizen = cr.findById(id);

		Citizen c1 = citizen.get();
		c1.setName(c.getName());
		c1.setVaccinationCenterId(c.getVaccinationCenterId());
		cr.save(c1);

		return cr.findAll();
	}

}
