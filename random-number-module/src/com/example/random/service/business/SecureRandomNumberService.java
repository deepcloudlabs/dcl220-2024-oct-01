package com.example.random.service.business;

import java.security.SecureRandom;
import java.util.Random;

import com.example.random.service.Quality;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

@Quality(level=QualityLevel.SECURE)
public class SecureRandomNumberService implements RandomNumberService {
	private final Random random = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		System.out.println("SecureRandomNumberService::generate");
		return random.nextInt(min, max);
	}

}
