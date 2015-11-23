package com.stunstun.spring.example.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stunstun.spring.example.Status;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

@Service
public class MonitorService {
	
	public static final String RETURN_STATUS_OK = "OK";
	
	private Status status = new Status(true);
	
	@Autowired
	private MonitorRepository monitorRepository;
	
	public boolean isEnable() {
		return (status.isEnable() && RETURN_STATUS_OK.equals(monitorRepository.selectStatus()));
	}
	
	public void setStatus(boolean enable) {
		status.setEnable(enable);
	}
}
