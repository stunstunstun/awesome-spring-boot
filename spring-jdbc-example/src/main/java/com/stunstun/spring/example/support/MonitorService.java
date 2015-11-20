package com.stunstun.spring.example.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

@Service
public class MonitorService {
	
	@Autowired
	private MonitorRepository monitorRepository;
	
	public void checkDataSource() {
		monitorRepository.selectStatus();
	}
}
