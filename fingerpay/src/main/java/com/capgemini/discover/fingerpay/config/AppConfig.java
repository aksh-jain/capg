package com.capgemini.discover.fingerpay.config;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

/***
 * 
 * @author Akshay Jain
 **/
@Import({ PersistenceJPAConfig.class })
@Configuration
public class AppConfig {

	@Bean
	public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("application.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}

	@Bean()
	public DozerBeanMapper mapper() {
		List<String> mappingFiles = new ArrayList<String>();
		mappingFiles.add("META-INF/dozer-configration-mapping.xml");

		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(mappingFiles);
		return mapper;
		
		//testing change
	}

}
