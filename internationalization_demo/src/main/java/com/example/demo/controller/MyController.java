package com.example.demo.controller;


import  java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class MyController { 
	@Autowired
	    private MessageSource messageSource;
	@RequestMapping(value = "test", method = RequestMethod.GET)
	  ResponseEntity test() {
		Locale locale = LocaleContextHolder.getLocale();
	    String message = messageSource.getMessage ("prop.message", null, locale );
		return  new ResponseEntity(message,HttpStatus.OK); 
	}
}
