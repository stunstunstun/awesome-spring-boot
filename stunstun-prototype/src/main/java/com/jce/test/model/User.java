/**
 * @file Member.java
 * @brief Member Source file
 */
/**
 *
 */

/**
 * @brief com.jce.api.social.model
 */
package com.jce.test.model;

/**
 * <PRE>
 * Class/Interface Name : Member
 * History
 *     1. JungMinHyeok(chujinnoon@joycity.com), 2012. 1. 6.
 * </PRE>
 * @brief MVC TEST User Bean
 * @date 2012. 1. 6.
 * @version 1.0.0
 * @author JungMinHyeok(chujinnoon@joycity.com)
 * @warning 
 */
public class User {
	
	private String id;
	private String name;
	private String first_name;
	private String last_name;
	private String link;
	private String username;
	private String gender;
	private String email;
	private int timezone;
	private String locale;
	private boolean verified;
	private String updated_time;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTimezone() {
		return timezone;
	}
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}
	
}
