package com.mumscrumv1.service;
import com.mumscrumv1.model.ReleaseBacklog;
import java.util.List;


public interface ReleaseService {
	public void addRelease(ReleaseBacklog release);
	public List<ReleaseBacklog> getAllRelelases();
	public abstract ReleaseBacklog getReleaseByCreatedBy(String username);
	public abstract List<ReleaseBacklog> getAllReleaseInformation();
	public abstract void deleteReleaseByID(int id);
	public abstract ReleaseBacklog getAllReleaseByID(int id);	
	public void updateRelease(ReleaseBacklog release, int id);
}
