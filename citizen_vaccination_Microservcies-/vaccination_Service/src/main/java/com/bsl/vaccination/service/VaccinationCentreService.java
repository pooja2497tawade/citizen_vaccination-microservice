package com.bsl.vaccination.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bsl.vaccination.model.VaccinationCentre;



@Service
public interface VaccinationCentreService {
	
	List<VaccinationCentre> addVactinationCenter(VaccinationCentre vc);
	List<VaccinationCentre>  getAllVactinationCenters();
	VaccinationCentre getVactinationCenterByID(int vcid);
	VaccinationCentre getVactinationCenterByName(String vcname);
	List<VaccinationCentre> deleteVactinationCenter(int vcid);
	List<VaccinationCentre> updateVactinationCenter(int vcid, VaccinationCentre vc);
	List<VaccinationCentre> getVactinationCentersByAddress(String vcaddress);
	
	
	

}