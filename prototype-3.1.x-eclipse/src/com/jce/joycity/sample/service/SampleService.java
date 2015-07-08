package com.jce.joycity.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jce.joycity.sample.repository.SampleRepository;

/**
 * @author MinHyuckJung(chujinnoon@joycity.com)
 * @date 2012. 10. 17.
 */

@Service("mainSvc")
public class SampleService {

	@Autowired
	private SampleRepository sampleRepository;
	
	public boolean checkDBConn(int num) throws Exception {
		
		try {
			
			int queryForIntResult = sampleRepository.checkDBConn(num);
			if( queryForIntResult == 1) return true; 			
			
		}catch(Exception e) {
			throw new Exception("Failed Connecting DB Server:" + e);
		}
		
		return false;
	}
	
	public int getCount() throws Exception {
		return sampleRepository.getCount();
	}
	
	public void throwTestException() throws Exception {
		throw new RuntimeException();
	}
}
