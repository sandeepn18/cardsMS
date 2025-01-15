package com.example.cardsms;

import com.example.cardsms.DTO.CardsInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CardsInfoDto.class)
public class CardsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsmsApplication.class, args);
	}

}
