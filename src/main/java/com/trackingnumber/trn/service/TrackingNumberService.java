package com.trackingnumber.trn.service;

import org.springframework.stereotype.Service;

import com.trackingnumber.trn.model.TrackingNumberResponse;

import reactor.core.publisher.Mono;

@Service
public interface TrackingNumberService {

	Mono<TrackingNumberResponse> generateTrackingNumber(String originCountryId, String destinationCountryId,
			String weight, String createdAt, String customerId, String customerName, String customerSlug);
}
