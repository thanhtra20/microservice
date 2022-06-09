package com.example.petdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class RestConfig {

  /*@Bean
  public Jackson2ObjectMapperBuilder jacksonBuilder() {
    Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
    b.indentOutput(true)
        .dateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
        .serializationInclusion(JsonInclude.Include.NON_NULL);
    return b;
  }*/

  @Bean
  RestTemplate restTemplate(
      RestTemplateBuilder rb) {

    RestTemplate template = rb.build();
    template.setRequestFactory(getNonStreamingBufferedRequestFactory());
    return template;
  }

  private static ClientHttpRequestFactory getNonStreamingBufferedRequestFactory() {
    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    log.info("disable output streaming for http requests factory");
    requestFactory.setOutputStreaming(false);
    return new BufferingClientHttpRequestFactory(requestFactory);
  }
}