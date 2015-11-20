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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
public class UserStory  implements Serializable {
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStoryName() {
		return StoryName;
	}
	public void setStoryName(String storyName) {
		StoryName = storyName;
	}
	public String getStoryDescription() {
		return StoryDescription;
	}
	public void setStoryDescription(String storyDescription) {
		StoryDescription = storyDescription;
	}
	public int getDevEstimateHour() {
		return DevEstimateHour;
	}
	public void setDevEstimateHour(int devEstimateHour) {
		DevEstimateHour = devEstimateHour;
	}
	public int getTesterEstimateHour() {
		return TesterEstimateHour;
	}
	public void setTesterEstimateHour(int testerEstimateHour) {
		TesterEstimateHour = testerEstimateHour;
	}
	public int getDevRemainingHour() {
		return DevRemainingHour;
	}
	public void setDevRemainingHour(int devRemainingHour) {
		DevRemainingHour = devRemainingHour;
	}
	public int getTesterRemainingHour() {
		return TesterRemainingHour;
	}
	public void setTesterRemainingHour(int testerRemainingHour) {
		TesterRemainingHour = testerRemainingHour;
	}
	public Employee getAssignedDeveloper() {
		return AssignedDeveloper;
	}
	public void setAssignedDeveloper(Employee assignedDeveloper) {
		AssignedDeveloper = assignedDeveloper;
	}
	public Employee getAssignedTester() {
		return AssignedTester;
	}
	public void setAssignedTester(Employee assignedTester) {
		AssignedTester = assignedTester;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public Date getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}
	public Date getDateAssigned() {
		return DateAssigned;
	}
	public void setDateAssigned(Date dateAssigned) {
		DateAssigned = dateAssigned;
	}
	public Date getDateCompleted() {
		return DateCompleted;
	}
	public void setDateCompleted(Date dateCompleted) {
		DateCompleted = dateCompleted;
	}
//	public Sprint getAssignedSprint() {
//		return AssignedSprint;
//	}
//	public void setAssignedSprint(Sprint assignedSprint) {
//		AssignedSprint = assignedSprint;
//	}
	public List<WorkLog> getWorkLogforUserStory() {
		return WorkLogforUserStory;
	}
	public void setWorkLogforUserStory(List<WorkLog> workLogforUserStory) {
		WorkLogforUserStory = workLogforUserStory;
	}
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
int id;
@Column(name="StoryName")
String StoryName;
@Column(name="StoryDescription")
String StoryDescription;
@Column(name="Dev_Estimate_Hour")
int DevEstimateHour;
@Column(name="Tester_Estimate_Hour")
int TesterEstimateHour;
@Column(name="Dev_Remaining_Hour")
int DevRemainingHour;
@Column(name="Tester_Remaining_Hour")
int TesterRemainingHour;

@OneToOne(fetch=FetchType.EAGER)
Employee AssignedDeveloper;

@OneToOne(fetch=FetchType.EAGER)
Employee AssignedTester;
@Column(name="Priority")
String Priority;
@Column(name="Status")
String Status;
@Column(name="CreatedBy")
String CreatedBy;
@Column(name="Date_Created")
Date DateCreated;
@Column(name="Date_Assigned")
Date DateAssigned;
@Column(name="Date_Complted")
Date DateCompleted;
//@OneToOne(cascade=CascadeType.ALL,orphanRemoval=false,fetch=FetchType.EAGER) 
//Sprint AssignedSprint;
@LazyCollection(LazyCollectionOption.FALSE)
@OneToMany(cascade=CascadeType.ALL)
List<WorkLog> WorkLogforUserStory;

}
