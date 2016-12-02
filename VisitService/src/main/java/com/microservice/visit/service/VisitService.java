package com.microservice.visit.service;

import java.util.List;

import com.microservice.visit.model.Visit;

public interface VisitService
{

	public List<Visit> listPatientVisits(Integer mrn);

	public boolean addVisit(Visit visit);

	public boolean removePatientVisit(Integer mrn, Integer visitId);

	public Visit editVisit(Integer mrn, Integer visitId);

	public boolean updateVisit(Visit visit);
}
