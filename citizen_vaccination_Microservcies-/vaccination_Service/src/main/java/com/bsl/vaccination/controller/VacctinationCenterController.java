package com.bsl.vaccination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bsl.vaccination.model.VaccinationCentre;
import com.bsl.vaccination.service.VaccinationCentreService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/api/v2")
public class VacctinationCenterController {
	
	@Value("${citizen_url}")
	private String GetAllCitizensById_API;

	@Autowired
	VaccinationCentreService vcs;
	
	@Autowired
	RestTemplate resttemplate;
	
//http://localhost:8081/api/v2/citizen/vccid/
	@GetMapping("/citizen/vccid/{vccId}")
	@HystrixCommand(fallbackMethod = "downCitizen")
	public ResponseEntity<String> getCitizensByVacctinationCenterId(@PathVariable int vccId) {
		
		System.out.println(GetAllCitizensById_API);
	
		return	resttemplate.exchange(GetAllCitizensById_API+vccId,HttpMethod.GET,null,String.class);
		//return resttemplate.getForObject(GetAllCitizensById_API+vccId, String.class);
			
		
	}
	

	@PostMapping(value = "/vcc/add", consumes = "application/json")
	public ResponseEntity<List> addVactinationCenter(@RequestBody VaccinationCentre vc) {

		List<VaccinationCentre> vcl = vcs.addVactinationCenter(vc);

		return new ResponseEntity<List>(vcl, HttpStatus.CREATED);
	}

	@GetMapping("/vcc/byid/{vcid}")
	public VaccinationCentre getbyVactinationCenterById(@PathVariable int vcid) {
		return vcs.getVactinationCenterByID(vcid);
	}

	@GetMapping("/vcc/byname/{vcname}")
	public VaccinationCentre getVactinationCenterByName(@PathVariable String vcname) {
		return vcs.getVactinationCenterByName(vcname);

	}

	@GetMapping("/vcc/byaddress/{vcaddress}")
	public List<VaccinationCentre> getVactinationCenterByAddress(@PathVariable String vcaddress) {
		return vcs.getVactinationCentersByAddress(vcaddress);

	}

	@GetMapping("/vcc/getall")
	public List<VaccinationCentre> getAllVactinationCenters() {
		return vcs.getAllVactinationCenters();
	}

	@DeleteMapping("/delete/vcc/byid/{vcid}")
	public List<VaccinationCentre> deleteVactinationCenter(@PathVariable int vcid) {

		return vcs.deleteVactinationCenter(vcid);
	}

	@PostMapping(value = "/update/vcc/{vcid}", consumes = "application/json")
	public List<VaccinationCentre> updateVactinationCenter(@PathVariable int vcid, @RequestBody VaccinationCentre vc) {
		return vcs.updateVactinationCenter(vcid, vc);

	}

}
