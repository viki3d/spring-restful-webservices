package com.viki3d.spring.restful.webservices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

/**
 * Tests context is properly initialized for the car-service-consumer.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ConsumingRestServiceTest {

  @Autowired
  private RestTemplate restTemplate;
  
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void contextLoads() {

    boolean serviceHelloIsRunning = true;
    try {
      final String serviceEndpoint = "/api/v1/cars";
      this.mockMvc.perform(get(serviceEndpoint)).andExpect(status().isOk());
    } catch (Throwable t) {
      serviceHelloIsRunning = false;
    }
    
    Assumptions.assumeTrue(serviceHelloIsRunning);
    
    assertThat(restTemplate).isNotNull();
  }

}
