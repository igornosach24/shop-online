package com.github.nosachigor23.shoponline;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopOnlineApplication {

	private static final Logger LOG = Logger.getLogger(ShopOnlineApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ShopOnlineApplication.class, args);

		LOG.debug("Application Started");

	}

}
