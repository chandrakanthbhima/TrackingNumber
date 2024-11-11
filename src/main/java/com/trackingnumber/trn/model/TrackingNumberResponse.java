package com.trackingnumber.trn.model;

import java.io.Serializable;

public class TrackingNumberResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String trackingNumber;
	private String createdAt;

	public TrackingNumberResponse(String trackingNumber, String createdAt) {
		this.trackingNumber = trackingNumber;
		this.createdAt = createdAt;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public String getCreatedAt() {
		return createdAt;
	}
}