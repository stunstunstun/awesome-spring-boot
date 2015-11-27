/**
 * 
 */
package com.stunstun.spring.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author stunstun(minhyuck.jung@nhnent.com)
 *
 */
@ConfigurationProperties(prefix = SlaveDatabaseProperties.PREFIX)
public class SlaveDatabaseProperties implements DatabaseProperties {

	public static final String PREFIX = "datasource.slave"; 

	private String driverClassName;
	
	private String url;
	
	private String userName;
	
	private String password;
	
	private int initialSize;
	
	private int maxActive;
	
	private int maxIdle;
	
	private int minIdle;
	
	private int maxWait;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}
	
	@Override
	public String toString() {
		return "SlaveDatabaseProperties[" + this.driverClassName + "]";
	}
}
