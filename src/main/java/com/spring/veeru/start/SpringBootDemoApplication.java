package com.spring.veeru.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author virupaksha.kuruva
 *
 */
@SpringBootApplication
@ComponentScan(basePackages ="com.spring.veeru")
@EntityScan( basePackages = {"com.spring.veeru"} ) // entities package name
@EnableJpaRepositories(basePackages = {"com.spring.veeru"})
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
