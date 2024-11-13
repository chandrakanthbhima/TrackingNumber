package com.trackingnumber.trn;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.trackingnumber.trn.model.TrackingNumberResponse;

@SpringBootApplication
public class TrackingNumberApplication {
	public static void main(String[] args) {
		SpringApplication.run(TrackingNumberApplication.class, args);
	}

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName("redis-10770.c244.us-east-1-2.ec2.redns.redis-cloud.com");
		redisStandaloneConfiguration.setPort(10770);
		redisStandaloneConfiguration.setPassword("HWReMj0qyR2guGiUu2HadB7E16zNpLg1");

		GenericObjectPoolConfig<?> poolConfig = new GenericObjectPoolConfig<>();
		JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling()
				.poolConfig(poolConfig).build();

		return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
	}

	@Bean
	public RedisTemplate<String, TrackingNumberResponse> redisTemplate() {
		RedisTemplate<String, TrackingNumberResponse> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		return template;
	}
}