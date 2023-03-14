package com.bsl.vaccination.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsl.vaccination.model.VaccinationCentre;
import com.bsl.vaccination.repositry.VaccinationCenterRepository;

@Service
public class VaccinationCentreServiceImpl implements VaccinationCentreService{
	
	@Autowired
	VaccinationCenterRepository vr;
	

	@Override
	public List<VaccinationCentre> addVactinationCenter(VaccinationCentre vc) {
		
		vr.save(vc);
		return vr.findAll();
	}

	@Override
	public List<VaccinationCentre> getAllVactinationCenters() {
		
		return vr.findAll();
	}

	@Override
	public VaccinationCentre getVactinationCenterByID(int vcid) {
		Optional<VaccinationCentre> vc = vr.findById(vcid);
		return vc.get();
	}

	@Override
	public VaccinationCentre getVactinationCenterByName(String vcname) {
		
		Optional<VaccinationCentre> vc = vr.findByVacctinationcentreName(vcname);
		
		return vc.get();
	}

	@Override
	public List<VaccinationCentre> deleteVactinationCenter(int vcid) {
		 vr.deleteById(vcid);
		
		return vr.findAll();
	}

	@Override
	public List<VaccinationCentre> updateVactinationCenter(int vcid, VaccinationCentre vc) {
		Optional<VaccinationCentre> vc1 = vr.findById(vcid);
		
		VaccinationCentre vc2=vc1.get();
	vc2.setVacctinationcentreId(vc.getVacctinationcentreId());
	vc2.setVactinationcentreAddress(vc.getVactinationcentreAddress());
		
		vr.save(vc2);
		return vr.findAll();
	}

	@Override
	public List<VaccinationCentre> getVactinationCentersByAddress(String vcaddress) {
		List<VaccinationCentre> vcl = vr.findByVactinationcentreAddress(vcaddress);
		
		return vcl ;
	}
	
	
	
	
	
	

}
