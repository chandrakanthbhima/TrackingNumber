package com.trackingnumber.trn.service;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.trackingnumber.trn.model.TrackingNumberResponse;

import reactor.core.publisher.Mono;

@Service
public class TrackingNumberServiceImpl implements TrackingNumberService {

	private static final Pattern TRACKING_NUMBER_PATTERN = Pattern.compile("^[A-Z0-9]{1,16}$");
	private final RedisTemplate<String, TrackingNumberResponse> redisTemplate;

	public TrackingNumberServiceImpl(RedisTemplate<String, TrackingNumberResponse> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	private String generateUniqueTrackingNumber() {
		String trackingNumber;
		do {
			trackingNumber = UUID.randomUUID().toString().replace("-", "").substring(0, 16).toUpperCase();
		} while (!TRACKING_NUMBER_PATTERN.matcher(trackingNumber).matches() || redisTemplate.hasKey(trackingNumber));
		return trackingNumber;
	}

	@Override
	public Mono<TrackingNumberResponse> generateTrackingNumber(String originCountryId, String destinationCountryId,
			String weight, String createdAt, String customerId, String customerName, String customerSlug) {
		String trackingNumber = generateUniqueTrackingNumber();
		String generatedAt = DateTimeFormatter.ISO_INSTANT.format(Instant.now());

		TrackingNumberResponse response = new TrackingNumberResponse(trackingNumber, generatedAt);

		redisTemplate.opsForValue().set(trackingNumber, response);

		return Mono.just(response);
	}
}