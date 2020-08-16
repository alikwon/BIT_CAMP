package com.aia.socket.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

public class PushVo {
	/**
	 * Push 타입
	 */

	
	/**
	 * payload
	 */
	private Object payload;

	private String query;
	
	private String timeType;
	
	private String messageType;
	
	public Object getPayload() {
		return payload;
	}
	
	public void setPayload(final Object payload) {
		this.payload = payload;
	}
	
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
	
	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
