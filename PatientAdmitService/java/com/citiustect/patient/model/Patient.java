package com.citiustect.patient.model;

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
@Table(name = "patient")
public class Patient
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer MRN;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "HEIGHT")
	private int height;

	@Column(name = "WEIGHT")
	private int weight;

	@Column(name = "ADMIT_DATE")
	private Date admitDate;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "ROOM")
	private String roomNumber;

	@Column(name = "ATTENDING_PHYSICIAN")
	private String attendingPhysician;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name = "VIP")
	private String vipPatient;

	@Column(name = "REASON_FOR_VISITS")
	private String reasonForVisits;

	public Integer getMRN()
	{
		return MRN;
	}

	public void setMRN(Integer mRN)
	{
		MRN = mRN;
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWeight()
	{
		return weight;
	}

	public void setWeight(int weight)
	{
		this.weight = weight;
	}

	public Date getAdmitDate()
	{
		return admitDate;
	}

	public void setAdmitDate(Date admitDate)
	{
		this.admitDate = admitDate;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getRoomNumber()
	{
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}

	public String getAttendingPhysician()
	{
		return attendingPhysician;
	}

	public void setAttendingPhysician(String attendingPhysician)
	{
		this.attendingPhysician = attendingPhysician;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getVipPatient()
	{
		return vipPatient;
	}

	public void setVipPatient(String vipPatient)
	{
		this.vipPatient = vipPatient;
	}

	public String getReasonForVisits()
	{
		return reasonForVisits;
	}

	public void setReasonForVisits(String reasonForVisits)
	{
		this.reasonForVisits = reasonForVisits;
	}

	@Override
	public String toString()
	{
		return "Patient [MRN=" + MRN + ", fullName=" + fullName + ", gender=" + gender + ", dob=" + dob + ", height=" + height + ", weight=" + weight
				+ ", admitDate=" + admitDate + ", location=" + location + ", roomNumber=" + roomNumber + ", attendingPhysician=" + attendingPhysician
				+ ", accountNumber=" + accountNumber + ", vipPatient=" + vipPatient + ", reasonForVisits=" + reasonForVisits + "]";
	}
}
