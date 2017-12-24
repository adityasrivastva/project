package com.aditya.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 1. @Configuration indicates that this class contains one or more bean methods annotated with 
 @Bean producing beans manageable by spring container. In our case, this class represent hibernate configuration.
 
 2. @ComponentScan is equivalent to context:component-scan base-package="..." in xml, 
 providing with where to look for spring managed beans/classes.
 
 3.@EnableTransactionManagement is equivalent to Spring’s tx:* XML namespace, 
 enabling Spring’s annotation-driven transaction management capability.
 
 4.@PropertySource is used to declare a set of properties(defined in a properties file in application classpath) 
 in Spring run-time Environment, providing flexibility to have different values in different application environments.
 
 
 * */

@Configuration
@ComponentScan(basePackages= {"com.aditya.shoppingbackend.dto"})
@EnableTransactionManagement
@PropertySource(value= {"classpath:db.properties"})
public class HibernateConfig {
	
	@Autowired 
	private Environment env;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("mysql.driver"));
		dataSource.setUrl(env.getRequiredProperty("mysql.url"));
		dataSource.setUsername(env.getRequiredProperty("mysql.user"));
		dataSource.setPassword(env.getRequiredProperty("mysql.password"));
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
		
		/*LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.aditya.spring.hibernate.dto");*/
		LocalSessionFactoryBean factoryBean= new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan(new String[] {"com.aditya.shoppingbackend.dto"});
		factoryBean.setHibernateProperties(getHibernateProperties());
		
		
		
		
		
		return factoryBean;
	}
	
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		//HibernateTransactionManager transactionManager= new HibernateTransactionManager(getSessionFactory());
		HibernateTransactionManager transactionManager= new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}
	
	
	//All the hibernate propeties will be required in this method
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        /*properties.put("C3P0_MIN_SIZE", env.getProperty("hibernate.c3p0.min_size"));
        properties.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
        properties.put(C3P0_ACQUIRE_INCREMENT, 
              env.getProperty("hibernate.c3p0.acquire_increment"));
        properties.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
        properties.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));*/
        
		 
		
		return properties;
	}
	

}
