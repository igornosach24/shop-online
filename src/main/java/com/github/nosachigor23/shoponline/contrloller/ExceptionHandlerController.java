package com.github.nosachigor23.shoponline.contrloller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerController {

	private static final Logger LOG = Logger.getLogger(ExceptionHandlerController.class);

	@ExceptionHandler(ControllerException.class)
	public @ResponseBody
	String handleException(ControllerException e) {

		LOG.error("Error: " + e.getMessage(), e);

		return "Error: " + e.getMessage();

	}
}
