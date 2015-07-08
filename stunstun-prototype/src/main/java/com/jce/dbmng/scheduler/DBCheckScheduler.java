package com.jce.dbmng.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jce.dbmng.dao.DBConnManager;

@Component("dbCheckScheduler")
public class DBCheckScheduler {

	@Autowired
	private DBConnManager DBConnManager;
	public static boolean isConn;

	public void connectionCheck() throws Exception {
		isConn = this.DBConnManager.isDBConn();
	}
}
