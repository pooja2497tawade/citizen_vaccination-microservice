package com.bsl.vaccination.repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsl.vaccination.model.VaccinationCentre;

@Repository
public interface VaccinationCenterRepository  extends JpaRepository<VaccinationCentre, Integer>{
	
	Optional<VaccinationCentre> findByVacctinationcentreName(String vcname);
	List<VaccinationCentre> findByVactinationcentreAddress(String vcaddress);

}
