package com.example.feign.learning.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {
  @Bean
  public OkHttpClient client(){
    return new OkHttpClient();
  }

  @Bean
  public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
    return new BasicAuthRequestInterceptor("user", "password");
  }

  /**
   * Four logging levels to choose from
   * NONE, BASIC, HEADERS, FULL
   */
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.BASIC;
  }

  @Bean
  public ErrorDecoder errorDecoder() {
    return new CustomErrorDecoder();
  }
}
