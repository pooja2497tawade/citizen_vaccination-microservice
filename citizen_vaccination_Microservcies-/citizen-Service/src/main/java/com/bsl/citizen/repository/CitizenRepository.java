package com.bsl.citizen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsl.citizen.model.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

	Optional<Citizen> findByName(String name);

	List<Citizen> findByVaccinationCenterId(int vaccinationCenterId);

}
