package com.mumscrumv1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mumscrumv1.model.WorkLog;

public interface WorkLogRepository extends CrudRepository<WorkLog, Integer>{
	

}
