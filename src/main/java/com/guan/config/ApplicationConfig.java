package com.guan.config;

import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories
@EnableTransactionManagement
class ApplicationConfig {

//  @Bean
//  public DataSource dataSource() {
//
//    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//    return builder.setType(EmbeddedDatabaseType.HSQL).build();
//  }
//
//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//      LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
//      emfb.setDataSource(dataSource);
//      emfb.setPackagesToScan("your.package.with.model"); 
//      emfb.setJpaVendorAdapter(jpaVendorAdapter());
//      emfb.setJpaPropertyMap(jpaPropertiesMap()); 
//      return emfb;
//  }
//
//  @Bean 
//  public JpaVendorAdapter jpaVendorAdapter() {
//      return new HibernateJpaVendorAdapter();
//  }
//
//  @Bean
//  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//      JpaTransactionManager transactionManager = new JpaTransactionManager();
//      transactionManager.setEntityManagerFactory(emf);
//      return transactionManager;
//  }
//
//  public Map<String, ?> jpaPropertiesMap() {
//      Properties properties = new Properties();
//      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); // assumption based on your pom-file
//      properties.setProperty("hibernate.hbm2ddl.auto", "..."); // you need to google for appropriate option
//      return properties;
//  }
}