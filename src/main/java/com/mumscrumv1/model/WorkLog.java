package com.mumscrumv1.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
public class WorkLog  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWorkDay() {
		return WorkDay;
	}
	public void setWorkDay(int workDay) {
		WorkDay = workDay;
	}
	public int getDevEffort() {
		return DevEffort;
	}
	public void setDevEffort(int devEffort) {
		DevEffort = devEffort;
	}
	public int getTestingEffort() {
		return TestingEffort;
	}
	public void setTestingEffort(int testingEffort) {
		TestingEffort = testingEffort;
	}
	public UserStory getUserStory() {
		return userStory;
	}
	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}
	private int WorkDay;
	int DevEffort;
	int TestingEffort;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(cascade=CascadeType.ALL)
	UserStory userStory;
	
	
}
