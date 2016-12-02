package com.microservice.visit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.visit.dao.VisitDAO;
import com.microservice.visit.model.Visit;

@Service
public class VisitServiceImpl implements VisitService
{
	private VisitDAO visitDAO;

	@Autowired
	public void setVisitDAO(VisitDAO visitDAO)
	{
		this.visitDAO = visitDAO;
	}

	@Override
	@Transactional
	public List<Visit> listPatientVisits(Integer mrn)
	{
		return visitDAO.listPatientVisits(mrn);
	}

	@Override
	@Transactional
	public boolean addVisit(Visit visit)
	{
		visitDAO.addVisit(visit);
		return true;
	}

	@Override
	@Transactional
	public boolean updateVisit(Visit visit)
	{
		visitDAO.updateVisit(visit);
		return true;
	}

	@Override
	@Transactional
	public boolean removePatientVisit(Integer mrn, Integer visitId)
	{
		visitDAO.removePatientVisit(mrn, visitId);
		return true;
	}

	@Override
	@Transactional
	public Visit editVisit(Integer mrn, Integer visitId)
	{
		return visitDAO.editVisit(mrn, visitId);
	}
}
