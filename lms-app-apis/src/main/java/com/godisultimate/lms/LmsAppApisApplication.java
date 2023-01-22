package com.godisultimate.lms;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

import com.godisultimate.lms.model.Dispatch;
import com.godisultimate.lms.model.Group;
import com.godisultimate.lms.model.Purchase;
import com.godisultimate.lms.model.Raffle;
import com.godisultimate.lms.model.RaffleStock;
import com.godisultimate.lms.model.User;

@SpringBootApplication
public class LmsAppApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsAppApisApplication.class, args);
	}
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	User user() {
		return new User();
	}
	
	@Bean
	Raffle raffle() {
		return new Raffle();
	}
	
	@Bean
	Group group() {
		return new Group();
	}
	
	@Bean
	Purchase purchase() {
		return new Purchase();
	}
	
	@Bean
	RaffleStock stock() {
		return new RaffleStock();
	}
	
	@Bean
	Dispatch dispatch() {
		return new Dispatch();
	}
}
