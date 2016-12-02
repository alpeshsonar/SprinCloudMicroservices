package com.microservice.visit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "patient_visit")
public class Visit
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visit_no")
	private Integer visitNo;

	private Integer MRN;

	@Column(name = "visit_date")
	private Date visitDate;

	@Column(name = "reason_for_visit")
	private String reasonForVisit;

	@Column(name = "attending_physician")
	private String attendingPhysician;

	@Column(name = "diagnosis")
	private String diagnosis;

	public Integer getVisitNo()
	{
		return visitNo;
	}

	public void setVisitNo(Integer visitNo)
	{
		this.visitNo = visitNo;
	}

	public Integer getMRN()
	{
		return MRN;
	}

	public void setMRN(Integer mRN)
	{
		MRN = mRN;
	}

	public Date getVisitDate()
	{
		return visitDate;
	}

	public void setVisitDate(Date visitDate)
	{
		this.visitDate = visitDate;
	}

	public String getReasonForVisit()
	{
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit)
	{
		this.reasonForVisit = reasonForVisit;
	}

	public String getAttendingPhysician()
	{
		return attendingPhysician;
	}

	public void setAttendingPhysician(String attendingPhysician)
	{
		this.attendingPhysician = attendingPhysician;
	}

	public String getDiagnosis()
	{
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis)
	{
		this.diagnosis = diagnosis;
	}

	@Override
	public String toString()
	{
		return "Visit [visitNo=" + visitNo + ", MRN=" + MRN + ", visitDate=" + visitDate + ", reasonForVisit=" + reasonForVisit + ", attendingPhysician="
				+ attendingPhysician + ", diagnosis=" + diagnosis + "]";
	}

}
