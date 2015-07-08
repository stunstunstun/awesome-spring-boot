package com.jce.test.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jce.test.dao.MainDao;

/**
 * <PRE>
 * Class/Interface Name : MainSvc
 * History
 *     1. JungMinHyeok(chujinnoon@joycity.com), 2012. 1. 5.
 * </PRE>
 * @brief 
 * @date 2012. 1. 5.
 * @version 1.0.0
 * @author JungMinHyeok(chujinnoon@joycity.com)
 * @warning 
 */

@Service
public class MainSvc {

	protected Logger logger = Logger.getLogger(MainSvc.class);
	
	@Autowired
	private MainDao mainDao;
	
	public boolean checkDBConn() throws Exception {
		try {
			int queryForIntResult = mainDao.checkDBConn();
			if( queryForIntResult == 1) return true; 
			else return false;
		}catch(Exception e){
			logger.error("Failed Connecting Server:" + e);
			return false;
		}
	}
	
	public void throw_exception() throws Exception {
		throw new RuntimeException();
	}
}
