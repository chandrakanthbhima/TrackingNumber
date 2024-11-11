package com.trackingnumber.trn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trackingnumber.trn.model.TrackingNumberResponse;
import com.trackingnumber.trn.service.TrackingNumberService;

import reactor.core.publisher.Mono;

@RestController
public class TrackingNumberController {
	@Autowired
	private TrackingNumberService trackingNumberService;

	@GetMapping("/next-tracking-number")
	public Mono<TrackingNumberResponse> generateTrackingNumber(
			@RequestParam(name = "origin_country_id") String originCountryId,
			@RequestParam(name = "destination_country_id") String destinationCountryId,
			@RequestParam(name = "weight") String weight, @RequestParam(name = "created_at") String createdAt,
			@RequestParam(name = "customer_id") String customerId,
			@RequestParam(name = "customer_name") String customerName,
			@RequestParam(name = "customer_slug") String customerSlug) {

		return trackingNumberService.generateTrackingNumber(originCountryId, destinationCountryId, weight, createdAt,
				customerId, customerName, customerSlug);
	}
}
