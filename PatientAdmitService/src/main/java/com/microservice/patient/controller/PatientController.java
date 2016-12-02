package com.microservice.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microservice.patient.model.Patient;
import com.microservice.patient.service.PatientService;

/**
 * Product controller.
 */
@Controller
public class PatientController
{

	private PatientService patientService;

	@Autowired
	public void setPatientService(PatientService patientService)
	{
		this.patientService = patientService;
	}

	//For list all patients
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String hello()
	{

		return "hello";
	}

	//For list all patients
	@RequestMapping(value = "/patients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Patient> listPersons()
	{
		List<Patient> patients = patientService.listPatients();
		return patients;
	}

	//For add and update patient both
	@RequestMapping(value = "/patient/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean addPerson(@RequestBody Patient patient)
	{
		if (patient.getID() == null || patient.getID() == 0)
		{
			patientService.addPatient(patient);
		}
		else
		{
			//existing patient, call update
			patientService.updatePatient(patient);
		}
		return true;
	}

	@RequestMapping(value = "/remove/{mrn}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean removePerson(@PathVariable("mrn") Integer mrn)
	{
		patientService.removePatient(mrn);
		return true;
	}

	@RequestMapping(value = "/edit/{mrn}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Patient editPerson(@PathVariable("mrn") int mrn)
	{
		return patientService.getPatientById(mrn);
	}

}
