package com.bsl.citizen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsl.citizen.model.Citizen;
import com.bsl.citizen.service.CitizenService;

@RestController
@RequestMapping("/api/v1")
public class CitizenCntroller {

	@Autowired
	CitizenService cs;


	@PostMapping(value = "/citizen/add", consumes = "application/json")
	public ResponseEntity<List> addCitizen(@RequestBody Citizen c) {
		List<Citizen> citizenList = cs.addCitizen(c);
		return new ResponseEntity<List>(citizenList, HttpStatus.CREATED);
	}

	
	@GetMapping("/citizen/getall")
	public List<Citizen> getAllCitizens() {
		List<Citizen> cl = cs.getAllCitizens();
		return cl;

	}


	@GetMapping("/citizen/getbyid/{id}")
	public Citizen getCitizenById(@PathVariable int id) {
		return cs.getCitizenById(id);

	}

//http://localhost:8080/api/v1/citizen/getbyvactinationcenter/23
	@GetMapping("/citizen/getbyvactinationcenter/{vcid}")
	public List<Citizen> getCitizenByVactinationCenterId(@PathVariable int vcid) {
		return cs.getCitizenByVaccinationCenterId(vcid);

	}

	
	@GetMapping("/citizen/byname/{name}")
	public Citizen getCitizenByName(@PathVariable String  name) {
		return cs.getCitizenByName(name);
	}
	
	
	@DeleteMapping("/delete/byid/{id}")
	public List<Citizen> deletcitizenbyId(@PathVariable int id){
		return cs.deleteCitizenById(id);
		
	}
	
	
	@PostMapping(value="/citizen/update",consumes = "application/json")
	public ResponseEntity<List<Citizen>> updateCitezen(@RequestBody Citizen c){
		
		List<Citizen> cl = cs.updateCitizen(c.getId(), c);
		
		
		return new ResponseEntity<List<Citizen>>(cl, HttpStatus.OK);
		
		
		
	}
	
	
	
}
