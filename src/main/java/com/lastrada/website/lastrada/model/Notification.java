package com.lastrada.website.lastrada.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String toneName;
	private boolean toneOn;
	
	
	public Notification() {
		
	}
	public Notification(String pathOfTone, boolean isToneOn) {
		super();
		this.toneName = pathOfTone;
		this.toneOn = isToneOn;
	}
	public String getToneName() {
		return toneName;
	}
	public void setToneName(String toneName) {
		this.toneName = toneName;
	}
	public boolean isToneOn() {
		return toneOn;
	}
	public void setToneOn(boolean toneOn) {
		this.toneOn = toneOn;
	}
	

	
	
	
	
	
	
}
