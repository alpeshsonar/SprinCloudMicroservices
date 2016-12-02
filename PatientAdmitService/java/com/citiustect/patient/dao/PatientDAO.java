package com.citiustect.patient.dao;

import java.util.List;

import com.citiustect.patient.model.Patient;

public interface PatientDAO
{
	public void addPatient(Patient patient);

	public void updatePatient(Patient patient);

	public List<Patient> listPatients();

	public Patient getPatientById(Integer mrn);

	public void removePatient(Integer mrn);
}
