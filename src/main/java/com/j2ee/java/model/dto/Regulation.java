package com.j2ee.java.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="RegulationConfig")
public class Regulation {
	
	@Id
	@GeneratedValue
	@Column(name="RegulationID")
	private int regulationID;
	
	@Column(name="Key")
	private String key;
	
	@Column(name="Value")
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
		this.regulationID = id;
		this.key = key;
		this.value = value;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return regulationID;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.regulationID = id;
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
