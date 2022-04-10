package com.myapp.machine.read.service.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageResponse implements Serializable {
	
	private static final long serialVersionUID = MessageResponse.class.hashCode();

	private String topic;
	private String ref;
	private String event;
	
	@JsonProperty("join_ref")
	private String joinRef;
	private Payload payload;
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getJoinRef() {
		return joinRef;
	}
	public void setJoinRef(String joinRef) {
		this.joinRef = joinRef;
	}
	public Payload getPayload() {
		return payload;
	}
	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	
	
	
}
