package com.mumscrumv1.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mumscrumv1.model.WorkLog;
import com.mumscrumv1.repository.WorkLogRepository;
import com.mumscrumv1.service.WorkLogService;

@Service
public class WorkLogServiceImpl implements WorkLogService{
	@Autowired
	WorkLogRepository workLogRepository;

	public void addTestWorkLog(WorkLog worklog) {
		
		 workLogRepository.save(worklog);
		
	}

	public void addDevWorkLog(WorkLog worklog) {
		workLogRepository.save(worklog);
	}

}
