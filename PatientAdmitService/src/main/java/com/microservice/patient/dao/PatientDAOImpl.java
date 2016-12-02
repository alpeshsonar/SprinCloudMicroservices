package com.microservice.patient.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservice.patient.model.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO
{

	private static final Logger logger = LoggerFactory.getLogger(PatientDAOImpl.class);

	public EntityManager entityManager;

	@Autowired
	public void setEntityManager(EntityManagerFactory emf)
	{
		this.entityManager = emf.createEntityManager();
	}

	@Override
	public void addPatient(Patient patient)
	{

		EntityTransaction tx = entityManager.getTransaction();
		try
		{
			tx.begin();
			entityManager.persist(patient);
			tx.commit();
			logger.info("Patient saved successfully, Patient Details=" + patient);
		}
		catch (Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
		}
	}

	@Override
	public void updatePatient(Patient patient)
	{
		EntityTransaction tx = entityManager.getTransaction();
		try
		{
			tx.begin();
			entityManager.merge(patient);
			tx.commit();
			logger.info("Patient updated successfully, Patient Details=" + patient);
		}
		catch (Exception e)
		{
			if (tx != null)
			{
				tx.rollback();
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Patient> listPatients()
	{
		List<Patient> patientList = entityManager.createQuery("from Patient").getResultList();
		logger.info("PatientList :: " + patientList);
		for (Patient p : patientList)
		{
			logger.info("Patient List::" + p);
		}
		return patientList;
	}

	@Override
	public Patient getPatientById(Integer mrn)
	{
		Patient patient = entityManager.find(Patient.class, mrn);
		logger.info("Patient loaded successfully, Patient details=" + patient);
		return patient;
	}

	@Override
	public void removePatient(Integer mrn)
	{
		Patient patient = entityManager.find(Patient.class, mrn);
		if (null != patient)
		{
			EntityTransaction tx = entityManager.getTransaction();
			try
			{
				tx.begin();
				entityManager.remove(patient);
				tx.commit();
			}
			catch (Exception e)
			{
				if (tx != null)
				{
					tx.rollback();
				}
			}
		}
		logger.info("Patient deleted successfully, Patient details=" + patient);

	}
}
