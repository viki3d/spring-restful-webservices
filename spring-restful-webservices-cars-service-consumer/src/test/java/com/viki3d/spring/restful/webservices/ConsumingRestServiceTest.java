package com.viki3d.spring.restful.webservices;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

/**
 * Test RestTemplate.
 */
@SpringBootTest
public class ConsumingRestServiceTest {

  @Autowired
  private RestTemplate restTemplate;

  @Test
  public void contextLoads() {
    assertThat(restTemplate).isNotNull();
  }

}
