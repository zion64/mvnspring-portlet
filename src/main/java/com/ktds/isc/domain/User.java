package com.ktds.isc.domain;

// Generated 2014. 4. 16 ?? 5:39:09 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private String	userid;
	private String	username;
	private Set		requestofdeletingsmartsheets	= new HashSet(0);

	public User() {
	}

	public User(String userid, String username) {
		this.userid = userid;
		this.username = username;
	}

	public User(String userid, String username, Set requestofdeletingsmartsheets) {
		this.userid = userid;
		this.username = username;
		this.requestofdeletingsmartsheets = requestofdeletingsmartsheets;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set getRequestofdeletingsmartsheets() {
		return this.requestofdeletingsmartsheets;
	}

	public void setRequestofdeletingsmartsheets(Set requestofdeletingsmartsheets) {
		this.requestofdeletingsmartsheets = requestofdeletingsmartsheets;
	}

}