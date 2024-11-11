package com.trackingnumber.trn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trackingnumber.trn.service.TrackingNumberService;

@RestController
public class TrackingNumberController {
	@Autowired
	private TrackingNumberService trackingNumberService;

	@GetMapping("/next-tracking-number")
	public String getNextTrackingNumber(@RequestParam("origin_country_id") String origin_country_id,
			@RequestParam("destination_country_id") String destination_country_id, @RequestParam("weight") double weight, @RequestParam("created_at") String created_at,
			@RequestParam("customer_id") String customer_id, @RequestParam("customer_name") String customer_name, @RequestParam("customer_slug") String customer_slug) {
		return trackingNumberService.generateTrackingNumber(origin_country_id, destination_country_id, weight,
				created_at, customer_id, customer_name, customer_slug);
	}
}