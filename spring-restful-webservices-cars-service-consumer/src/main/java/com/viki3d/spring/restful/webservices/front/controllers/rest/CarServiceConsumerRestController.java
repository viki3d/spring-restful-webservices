package com.viki3d.spring.restful.webservices.front.controllers.rest;

import com.viki3d.spring.restful.webservices.front.api.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Consumes car-rest-service.
 */
@RestController
public class CarServiceConsumerRestController {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private RestTemplate restTemplate;
  
  /**
   * Consumes REST object.
   *
   * <p><a href="http://localhost:8081/obj/1">test link</a></p>
   */
  @GetMapping("/obj/{id}")
  public String consumeObject(@PathVariable(required = true) long id) {
    final String url = "http://localhost:8080/api/v1/cars/" + Long.toString(id);
    Car car = restTemplate.getForObject(url, Car.class);
    return car.toString();
  }
  
  /**
   * Consumes REST by URI template. Receives response as {@code ResponseEntity}.
   *
   * <p><a href="http://localhost:8081/ext">test link</a></p>
   */
  @GetMapping("/ext")
  public String consumeExtended() {
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
    // Consumed -> car:[id = 1, brand = Mazda, model = 6, color = red]
    logger.debug("Consumed -> " + car.toString());
    return car.toString();
  }
  
}
