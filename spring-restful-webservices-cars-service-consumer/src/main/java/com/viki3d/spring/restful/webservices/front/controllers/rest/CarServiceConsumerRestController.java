package com.viki3d.spring.restful.webservices.front.controllers.rest;

import com.viki3d.spring.restful.webservices.front.api.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Consumes car-rest-service.
 */
@RestController
public class CarServiceConsumerRestController {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * Consumes REST object.
   *
   * <p><a href="http://localhost:8081/obj">test link</a></p>
   */
  @GetMapping("obj")
  public String consumeObject() {
    RestTemplateBuilder builder = new RestTemplateBuilder();
    RestTemplate restTemplate = builder.build();
    final String url = "http://localhost:8080/api/v1/cars/1";
    Car car = restTemplate.getForObject(url, Car.class);
    return car.toString();
  }
  
  /**
   * Consumes REST by URL.
   *
   * <p><a href="http://localhost:8081/ext">test link</a></p>
   */
  @GetMapping("ext")
  public String consumeExtended() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Car> response = null;
    HttpHeaders headers = new HttpHeaders();
    headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
    final String url = "http://localhost:8080/api/v1/cars/1";
    try {
      response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), Car.class);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }
    Car car = response.getBody();
    logger.debug("Consumed: " + car.toString());
    return car.toString();
  }
  
}
