package com.microservice.visit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microservice.visit.model.Visit;
import com.microservice.visit.service.VisitService;

@Controller
@CrossOrigin
public class VisitController
{

	private VisitService visitService;

	@Autowired
	public void setVisitService(VisitService visitService)
	{
		this.visitService = visitService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String hello()
	{

		return "hello Visit";
	}

	//For list all visits of patients
	@RequestMapping(value = "/visits/{mrn}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Visit> listVisits(@PathVariable("mrn") Integer mrn)
	{
		List<Visit> visits = visitService.listPatientVisits(mrn);
		return visits;
	}

	//For add patient visit
	@RequestMapping(value = "/visit/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean addVisit(@RequestBody Visit visit)
	{
		if (visit.getVisitNo() == null || visit.getVisitNo() != 0)
		{
			visitService.addVisit(visit);
		}
		else
		{
			visitService.updateVisit(visit);
		}
		return true;
	}

	@RequestMapping(value = "/visit/remove/{mrn}/{visit_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean removePatientVisit(@PathVariable("mrn") Integer mrn, @PathVariable("visit_id") Integer visitId)
	{
		visitService.removePatientVisit(mrn, visitId);
		return true;
	}

	@RequestMapping(value = "/visit/edit/{mrn}/{visit_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Visit editVisit(@PathVariable("mrn") Integer mrn, @PathVariable("visit_id") Integer visitId)
	{
		return visitService.editVisit(mrn, visitId);
	}

}
