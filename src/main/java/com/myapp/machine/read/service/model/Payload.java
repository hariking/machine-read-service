package com.myapp.machine.read.service.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload implements Serializable{
 

	private static final long serialVersionUID = Payload.class.hashCode();
	private String id;
	@JsonProperty("machine_id")
	private String machineId;
	private String status;
	private String timestamp;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
