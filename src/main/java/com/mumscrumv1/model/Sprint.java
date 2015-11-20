package com.mumscrumv1.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.aspectj.lang.annotation.control.CodeGenerationHint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
public class Sprint  implements Serializable{
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSprintName() {
		return SprintName;
	}

	public void setSprintName(String sprintName) {
		SprintName = sprintName;
	}

	public String getSprintDescription() {
		return SprintDescription;
	}

	public void setSprintDescription(String sprintDescription) {
		SprintDescription = sprintDescription;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}

	public int getNoOfWorkDayInSprint() {
		return NoOfWorkDayInSprint;
	}

	public void setNoOfWorkDayInSprint(int noOfWorkDayInSprint) {
		NoOfWorkDayInSprint = noOfWorkDayInSprint;
	}

	public Date getDateCreated() {
		return DateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}

	public Date getDateCompleted() {
		return DateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		DateCompleted = dateCompleted;
	}

	public Employee getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(Employee createdBy) {
		CreatedBy = createdBy;
	}

	public List<UserStory> getUserStories() {
		return UserStories;
	}

	public void setUserStories(List<UserStory> userStories) {
		UserStories = userStories;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column(name="Sprint_Name")
	String SprintName;
	@Column(name="Sprint_Description")
	String SprintDescription;
	@Column(name="Status")
	String Status;
	@Column(name="Priority")
	String Priority;
	@Column(name="Work_Day")
	int NoOfWorkDayInSprint;
	@Column(name="Date_Created")
	Date DateCreated;
	@Column(name="Date_Completed")
	Date DateCompleted;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	Employee CreatedBy;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, orphanRemoval=true)
	List<UserStory> UserStories;

}
