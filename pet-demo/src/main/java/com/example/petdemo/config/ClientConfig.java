package com.example.petdemo.config;

import com.example.petdemo.client.api.AnimalControllerApi;
import com.example.petdemo.client.invoker.ApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class ClientConfig {

  @Bean
  AnimalControllerApi animalControllerApi(
      @Value("${endpoints.client-url}") String url, RestTemplate restTemplate) {
    return new AnimalControllerApi(new ApiClient(restTemplate).setBasePath(url));
  }
}
