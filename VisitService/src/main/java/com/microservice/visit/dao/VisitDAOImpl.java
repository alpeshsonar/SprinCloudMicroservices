package com.microservice.visit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.microservice.visit.model.Visit;

@Repository
public class VisitDAOImpl implements VisitDAO
{

	private static final Logger logger = LoggerFactory.getLogger(VisitDAOImpl.class);

	public EntityManager entityManager;

	@Autowired
	public void setEntityManager(EntityManagerFactory emf)
	{
		this.entityManager = emf.createEntityManager();
	}

	@Override
	public List<Visit> listPatientVisits(Integer mrn)
	{
		@SuppressWarnings("unchecked")
		List<Visit> visitList = entityManager.createQuery("from Visit where mrn = :mrn").setParameter("mrn", mrn).getResultList();
		logger.info("visitList :: " + visitList);
		for (Visit v : visitList)
		{
			logger.info("VisitList List::" + v);
		}
		return visitList;
	}

	@Override
	public void addVisit(Visit visit)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(visit);
		tx.commit();
		logger.info("Visit saved successfully, Visit Details=" + visit);

	}

	@Override
	public void updateVisit(Visit visit)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(visit);
		tx.commit();
		logger.info("Visit saved successfully, Visit Details=" + visit);

	}

	@Override
	public void removePatientVisit(Integer mrn, Integer visitId)
	{
		Visit visit = entityManager.find(Visit.class, visitId);
		if (null != visit)
		{
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(visit);
			tx.commit();
		}
		logger.info("Visit deleted successfully, Patient details=" + visit);
	}

	@Override
	public Visit editVisit(Integer mrn, Integer visitId)
	{
		Visit visit = entityManager.find(Visit.class, visitId);
		logger.info("Visit loaded successfully, Patient details=" + visit);
		return visit;
	}
}
