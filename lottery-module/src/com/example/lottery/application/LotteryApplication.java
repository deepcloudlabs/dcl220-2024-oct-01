package com.example.lottery.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.Quality;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

public class LotteryApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		var lotteryService = new StandardLotteryService();
		var randomNumberServiceFound = getRandomNumberService();
		randomNumberServiceFound.ifPresent( randomNumberService -> {
			lotteryService.setRandomNumberService(randomNumberService);
			lotteryService.draw(60, 6, 10).forEach(System.out::println);
			
		});
	}

	public static Optional<RandomNumberService> getRandomNumberService() throws FileNotFoundException, IOException {
		var properties = new Properties();
		properties.load(new FileInputStream(new File("src","application.properties")));
		var qualityLevel = QualityLevel.valueOf(properties.getProperty("random.service"));
		var randomNumberServices = ServiceLoader.load(RandomNumberService.class);
		for (var randomNumberService : randomNumberServices) {
			var clazz = randomNumberService.getClass();
			if (clazz.isAnnotationPresent(Quality.class)) {
				var quality = clazz.getAnnotation(Quality.class);
				if (quality.level().equals(qualityLevel)) {
					return Optional.of(randomNumberService);
				}
			}
		}
		return Optional.empty();
	}
}
