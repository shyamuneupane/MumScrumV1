package com.mumscrumv1.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name="Employee")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int EmployeeID;
	
	@Column(name="FirstName")
	String firstName;
	
	@Column(name="MiddleName")
	String middleName;
	
	@Column(name="LastName")
	String lastName;
	
	@Column(name="SocialSecurity")
	String SSN;
	
	@Column(name="Salary")
	long salary;
	
	@Column(name="HomePhone")
	String homePhone;
	
	@Column(name="officePhone")
	String officePhone;
	
	@Column(name="MobilePhone")
	String mobilePhone;
	
	@Column(name="EmailAddress")
	String email;
	
	@Column(name="BirthDate")
	Date bithday;
	
	@Column(name="officeName")
	String oficeName;
	
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBithday() {
		return bithday;
	}
	public void setBithday(Date bithday) {
		this.bithday = bithday;
	}
	public String getOficeName() {
		return oficeName;
	}
	public void setOficeName(String oficeName) {
		this.oficeName = oficeName;
	}
	
	@OneToOne(fetch=FetchType.EAGER,  cascade =  CascadeType.ALL, orphanRemoval = true)
	UserCredential userCredential;
	
	

	@OneToOne(fetch=FetchType.EAGER,cascade =  CascadeType.ALL, orphanRemoval = true)
	Address address;


	public int getEmployeeID() {
		return EmployeeID;
	}


	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getSSN() {
		return SSN;
	}


	public void setSSN(String sSN) {
		SSN = sSN;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	public UserCredential getUserCredential() {
		return userCredential;
	}


	public void setUserCredential(UserCredential userCredential) {
		this.userCredential = userCredential;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	public  String toString(){
		return "EmployeeID:"+this.EmployeeID;
	}

}
