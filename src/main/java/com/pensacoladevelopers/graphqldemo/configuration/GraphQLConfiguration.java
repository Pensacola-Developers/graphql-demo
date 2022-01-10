package com.pensacoladevelopers.graphqldemo.configuration;


import com.pensacoladevelopers.graphqldemo.graphql.Mutation;
import com.pensacoladevelopers.graphqldemo.graphql.Query;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfiguration {

  @Bean
  Query queryResolver() {
    return new Query();
  }

  @Bean
  Mutation mutationResolver() {
    return new Mutation();
  }
}