package com.stjerndal.iotservice;
import com.stjerndal.iotservice.entity.Sensor;
import com.stjerndal.iotservice.entity.SensorData;
import com.stjerndal.iotservice.repository.SensorDataRepository;
import com.stjerndal.iotservice.repository.SensorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class IotServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotServiceApplication.class, args);
	}
	/*
		@Bean
		CommandLineRunner init(SensorRepository sensorRepository,SensorDataRepository sensorDataRepository) {
			return (evt) -> Arrays.asList(
					"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
					.forEach(
							a -> {
								Sensor sensor = sensorRepository.save(new Sensor(a,"password"));
								sensorDataRepository.save(new SensorData(sensor,new Date(), (long) 10));
								sensorDataRepository.save(new SensorData(sensor,new Date(), (long) 11));

							});


	}
	*/
}
