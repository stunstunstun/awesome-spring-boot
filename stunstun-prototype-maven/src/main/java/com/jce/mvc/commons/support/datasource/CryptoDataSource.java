package com.jce.mvc.commons.support.datasource;

import org.apache.commons.dbcp.BasicDataSource;

import com.jce.mvc.commons.util.encrypt.AES;
/**
 * @author psme324 hye-jeong kim 2013.02.01
 */
public class CryptoDataSource extends BasicDataSource{
	@Override
	public synchronized void setUrl(String url){
		try{
			super.setUrl(AES.decrypt(url));
		}catch(Exception e){
			System.out.println("Error in AES.decrypt(url) >>> " + e.getMessage());
		}
	}
	
	@Override
	public void setUsername(String username){
		try{
			super.setUsername(AES.decrypt(username));
		}catch(Exception e){
			System.out.println("Error in AES.decrypt(username) >>> " + e.getMessage());
		}
	}
	
	@Override
	public void setPassword(String password){
		try{
			super.setPassword(AES.decrypt(password));
		}catch(Exception e){
			System.out.println("Error in AES.decrypt(password) >>> " + e.getMessage());
		}
	}
}