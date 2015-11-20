package com.stunstun.spring.common.support.datasource;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
public class CryptoDataSource extends BasicDataSource {
	
	@Override
	public synchronized void setUrl(String url){
		super.setUrl(url);
	}
	
	@Override
	public void setUsername(String username){
		super.setUsername(username);
	}
	
	@Override
	public void setPassword(String password){
		super.setPassword(password);
	}
}