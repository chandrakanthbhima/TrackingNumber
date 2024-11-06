package com.trackingnumber.trn;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TrackingNumberService {
	public String generateTrackingNumber(String originCountryId, String destinationCountryId, double weight, String createdAt, String customerId, String customerName, String customerSlug) {
		// Generate a unique tracking number based on UUID and limit to 16 characters 
		return UUID.randomUUID().toString().substring(0, 16).toUpperCase(); 
		}
	}
}