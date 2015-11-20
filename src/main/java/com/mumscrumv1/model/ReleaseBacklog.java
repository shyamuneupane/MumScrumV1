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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
public class ReleaseBacklog  implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Release_id")
	int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReleaseName() {
		return ReleaseName;
	}

	public void setReleaseName(String releaseName) {
		ReleaseName = releaseName;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getEstimatedReleseDate() {
		return EstimatedReleseDate;
	}

	public void setEstimatedReleseDate(String estimatedReleseDate) {
		EstimatedReleseDate = estimatedReleseDate;
	}

	public String getActualReleaseDate() {
		return ActualReleaseDate;
	}

	public void setActualReleaseDate(String actualReleaseDate) {
		ActualReleaseDate = actualReleaseDate;
	}

	public List<Sprint> getReleasedSprints() {
		return ReleasedSprints;
	}

	public void setReleasedSprints(List<Sprint> releasedSprints) {
		ReleasedSprints = releasedSprints;
	}

	
	@Column(name="Release_Name")
	String ReleaseName;
	@Column(name="Status")
	String Status;
	@Column(name="Estimated_ReleaseDate")
	String EstimatedReleseDate;
	@Column(name="Actual_ReleaseDate")
	String ActualReleaseDate;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=false)
	List<Sprint> ReleasedSprints;
}
