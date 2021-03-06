package com.boraji.tutorial.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.boraji.tutorial.spring.entity.User;
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { 
      @ComponentScan("com.boraji.tutorial.spring.dao"),
      @ComponentScan("com.boraji.tutorial.spring.service") 
    })
public class AppConfig {

	
	private Environment env;
	
	@Bean
	   public DataSource getDataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	      dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	      dataSource.setUsername("sys as sysdba");
	      dataSource.setPassword("tiger");
	      return dataSource;
	   }
	 @Bean
	   public LocalSessionFactoryBean getSessionFactory() {
	      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	      factoryBean.setDataSource(getDataSource());
	      
	      Properties props=new Properties();
	      props.put("hibernate.show_sql", "true");
	      props.put("hibernate.hbm2ddl.auto","update");
	      props.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");

	      factoryBean.setHibernateProperties(props);
	      factoryBean.setAnnotatedClasses(User.class);
	      return factoryBean;
	   }
	 
	 @Bean
	   public HibernateTransactionManager getTransactionManager() {
	      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	      transactionManager.setSessionFactory(getSessionFactory().getObject());
	      return transactionManager;
	   }
	
}
