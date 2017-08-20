package com.capgemini.discover.fingerpay.rest.service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.discover.fingerpay.core.IAppManager;
import com.capgemini.discover.fingerpay.rest.request.UserDetailsRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Akshay Jain
 *
 */

@RestController
@RequestMapping(value = "/fingerpay", produces = "application/json;charset=UTF-8")
public class AppServiceClass {

	public static final Logger log = LoggerFactory.getLogger(AppServiceClass.class);

	@Resource(name = "appManager")
	IAppManager appManager;

	@Resource(name = "objectMapper")
	ObjectMapper objectMapper;

	@RequestMapping(value = "/register/{key}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> signUpGoogle(@PathVariable("key") @NotNull String publicKey,
			@RequestBody UserDetailsRequest user) throws JsonProcessingException {

		boolean isRegistered = appManager.registerUser(publicKey, user);

		return new ResponseEntity<>(objectMapper.writeValueAsString(isRegistered), HttpStatus.OK);
	}

	@RequestMapping(value = "/validate/transaction", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> validateTransaction(@RequestBody UserDetailsRequest user)
			throws JsonProcessingException {

		boolean isTransactionSuccessful = appManager.validateTransaction(user);

		return new ResponseEntity<>(objectMapper.writeValueAsString(isTransactionSuccessful), HttpStatus.OK);
	}
}
