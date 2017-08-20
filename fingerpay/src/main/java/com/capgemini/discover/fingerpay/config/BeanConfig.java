package com.capgemini.discover.fingerpay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.discover.fingerpay.core.IAppManager;
import com.capgemini.discover.fingerpay.core.impl.AppManager;
import com.capgemini.discover.fingerpay.dao.IAppRepository;
import com.capgemini.discover.fingerpay.dao.impl.AppRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/***
 * 
 * @author Akshay Jain
 *
 */
@Configuration
public class BeanConfig {

	@Bean
	public IAppRepository appRepository() {
		return new AppRepository();
	}

	@Bean
	public IAppManager appManager() {
		return new AppManager();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
