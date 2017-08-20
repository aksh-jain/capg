package com.capgemini.discover.fingerpay.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/***
 * 
 * @author Akshay Jain
 * 
 **/

@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig {

	private static final String ENTITY_PACKAGE = "com.capgemini.discover.fingerpay.entity";

	@Value("${dbDriver}")
	private String driverClassName;

	@Value("${dbUrl}")
	private String url;

	@Value("${dbUser}")
	private String username;

	@Value("${dbPassword}")
	private String password;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.showSql}")
	private String hibernateShowSql;

	@Value("${hibernate.formatSql}")
	private String hibernateFormatSql;

	@Value("${hibernate.generateStatistics}")
	private String hibernateGenerateStatistics;

	@Value("${javax.persistence.query.timeout}")
	private String queryTimeout;

	@Value("${hibernate.temp.useJdbcMetadataDefaults}")
	private String jdbcMetadataDefaults;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;

	@Value("${loadStaticData}")
	private Boolean loadStaticData;

	@Value("${loadTestData}")
	private Boolean loadTestData;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { ENTITY_PACKAGE });
		sessionFactory.setHibernateProperties(getHibernateProperties());

		return sessionFactory;
	}

	@Bean()
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory);
		return htm;
	}

	@Bean
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", hibernateShowSql);
		properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
		properties.put("hibernate.format_sql", hibernateFormatSql.toString());
		properties.put("hibernate.generate_statistics", hibernateGenerateStatistics.toString());
		properties.put("hibernate.temp.use_jdbc_metadata_defaults", jdbcMetadataDefaults.toString());
		properties.put("javax.persistence.query.timeout", queryTimeout.toString());

		List<String> importFileList = new ArrayList<>();

		if (loadStaticData) {

			importFileList.add("static_data/DN_DONOR_DTL.sql");

		}

		if (loadTestData) {

			importFileList.add("");

		}

		String importFileString = "";
		int iterationCounter = 0;
		for (String s : importFileList) {
			iterationCounter++;
			if (iterationCounter == 1) {
				importFileString += s;
			} else {
				importFileString += "," + s;
			}
		}

		properties.setProperty("hibernate.hbm2ddl.import_files", importFileString);

		return properties;
	}

}
