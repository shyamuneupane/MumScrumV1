package com.mumscrumv1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="Address")
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int ID;	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name="Street")
	String street;
	
	@Column(name="City")
	String city;
	
	@Column(name="State")
	String state;
	
	@Column(name="Zip")
	String zip;
	
	@Column (name="Building_Number")
	String buildingNo;
	
	@Column (name="Room_Number")
	String roomNo;
	
	@Column (name="Mail_Room_No")
	String mailRoomNo;
	
	
	public String getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getMailRoomNo() {
		return mailRoomNo;
	}
	public void setMailRoomNo(String mailRoomNo) {
		this.mailRoomNo = mailRoomNo;
	}
	//added comments to get Adress
	public String toString(){
		return "state: "+state+" City: "+city +" Street: "+street;
	}

}
