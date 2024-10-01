package com.example.random.service.business;

import java.util.concurrent.ThreadLocalRandom;

import com.example.random.service.Quality;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

@Quality(level=QualityLevel.FAST)
public class FastRandomNumberService implements RandomNumberService {

	@Override
	public int generate(int min, int max) {
		System.out.println("FastRandomNumberService::generate");
		return ThreadLocalRandom.current().nextInt(min, max);
	}

}
