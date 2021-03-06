package com.microservice.patient.service;

import java.util.List;

import com.microservice.patient.model.Patient;

public interface PatientService
{
	public void addPatient(Patient patient);

	public void updatePatient(Patient patient);

	public List<Patient> listPatients();

	public Patient getPatientById(Integer mrn);

	public void removePatient(Integer mrn);
}
