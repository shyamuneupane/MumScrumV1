package com.mumscrumv1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mumscrumv1.model.ReleaseBacklog;
import com.mumscrumv1.repository.ReleaseRepository;
import com.mumscrumv1.service.ReleaseService;

@Service
public class ReleaseServiceimpl implements ReleaseService {

    @Autowired
    ReleaseRepository releaseRepository;

    public void addRelease(ReleaseBacklog release) {
        System.out.println("********%%%%%%%%%%%%%%%%%%%%%%%%%%%%********");
        ReleaseBacklog rel = releaseRepository.save(release);
    }

    public List<ReleaseBacklog> getAllRelelases() {
        List<ReleaseBacklog> releaseList = (List<ReleaseBacklog>) releaseRepository.findAll();
        return releaseList;
    }

    public ReleaseBacklog getReleaseByCreatedBy(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ReleaseBacklog> getAllReleaseInformation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteReleaseByID(int id) {
        releaseRepository.delete(id);
    }

    public ReleaseBacklog getAllReleaseByID(int id) {
        ReleaseBacklog release = releaseRepository.findOne(id);
        return release;
    }

    public void updateRelease(ReleaseBacklog release, int id) {
      // releaseRepository.updateRelease(release.getReleaseName(), release.getStatus(), release.getEstimatedReleseDate(), release.getActualReleaseDate(), id);
    	releaseRepository.save(release);
    }

}
