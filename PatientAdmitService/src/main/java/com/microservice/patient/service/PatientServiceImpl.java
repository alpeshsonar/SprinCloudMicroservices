package com.microservice.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.patient.dao.PatientDAO;
import com.microservice.patient.model.Patient;

@Service
public class PatientServiceImpl implements PatientService
{
	private PatientDAO patientDAO;

	@Autowired
	public void setPatientDAO(PatientDAO patientDAO)
	{
		this.patientDAO = patientDAO;
	}

	@Override
	@Transactional
	public void addPatient(Patient patient)
	{
		patientDAO.addPatient(patient);
	}

	@Override
	@Transactional
	public void updatePatient(Patient patient)
	{
		patientDAO.updatePatient(patient);

	}

	@Override
	@Transactional
	public List<Patient> listPatients()
	{
		return patientDAO.listPatients();
	}

	@Override
	@Transactional
	public Patient getPatientById(Integer mrn)
	{
		return patientDAO.getPatientById(mrn);
	}

	@Override
	@Transactional
	public void removePatient(Integer mrn)
	{
		patientDAO.removePatient(mrn);
	}
}
