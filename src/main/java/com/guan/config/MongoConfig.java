package com.guan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
//http://docs.spring.io/spring-data/mongodb/docs/1.5.4.RELEASE/reference/html/mapping-chapter.html

@Configuration
@EnableMongoRepositories("com.guan.repo")
public class MongoConfig extends AbstractMongoConfiguration {
   @Override
   protected String getDatabaseName() {
      return "mao";
   }

   @Override
   public Mongo mongo() throws Exception {
      return new MongoClient("127.0.0.1", 27017);
   }

   @Override
   protected String getMappingBasePackage() {
      return "com.guan.domain";
   }
}
