package com.j2ee.java.model.dto;

import org.springframework.stereotype.Component;

@Component
public class Regulation {
	private int id;
	private String key;
	private String value;
	/**
	 * 
	 */
	public Regulation() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param key
	 * @param value
	 */
	public Regulation(int id, String key, String value) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
