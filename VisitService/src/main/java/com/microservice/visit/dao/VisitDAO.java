package com.microservice.visit.dao;

import java.util.List;

import com.microservice.visit.model.Visit;

public interface VisitDAO
{
	public List<Visit> listPatientVisits(Integer mrn);

	public void addVisit(Visit visit);

	public void removePatientVisit(Integer mrn, Integer visitId);

	public Visit editVisit(Integer mrn, Integer visitId);

	void updateVisit(Visit visit);
}
