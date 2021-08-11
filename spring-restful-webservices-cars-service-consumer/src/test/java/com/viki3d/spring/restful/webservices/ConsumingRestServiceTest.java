package com.viki3d.spring.restful.webservices;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

/**
 * Tests context is properly initialized for the car-service-consumer. Like check if RestTemplate 
 * Bean is ready. 
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ConsumingRestServiceTest {

  @Autowired
  private RestTemplate restTemplate;  

  @Test
  public void testContextLoads() {
    assertThat(restTemplate).isNotNull();
  }
  
}
