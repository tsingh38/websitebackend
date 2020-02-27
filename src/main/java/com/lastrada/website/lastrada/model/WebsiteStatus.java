package com.lastrada.website.lastrada.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class WebsiteStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	 // 0 is offline and 1 is online
	private boolean status;
	private String message;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

	
	
	


	
	
	
}
