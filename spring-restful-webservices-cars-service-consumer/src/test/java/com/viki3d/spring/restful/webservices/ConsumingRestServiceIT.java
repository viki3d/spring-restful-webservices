package com.viki3d.spring.restful.webservices;

import static org.assertj.core.api.Assertions.assertThat;

import com.viki3d.spring.restful.webservices.front.api.model.Car;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Integration test.
 */
@SpringBootTest
public class ConsumingRestServiceIT {

  @Autowired
  private RestTemplate restTemplate;

  @Test
  public void smokeTestRestTemplate() {
    assertThat(restTemplate).isNotNull();
  }

  @Test
  public void testGetCars() throws Exception {
    boolean carsServiceIsRunning = true;
    ResponseEntity<Car[]> response = null;
    try {
      response = this.restTemplate.getForEntity("http://localhost:8080/api/v1/cars", Car[].class);
    } catch (Exception ex) {
      carsServiceIsRunning = false;
    }

    Assumptions.assumeTrue(carsServiceIsRunning);
    Car[] cars = response.getBody(); //intentionally explicit syntax
    assertThat(cars.length == 4);
  }

  @Test
  public void testGetCar1() throws Exception {
    boolean carsServiceIsRunning = true;
    Car car = null;
    try {
      car = this.restTemplate.getForObject("http://localhost:8080/api/v1/cars/1", Car.class);
    } catch (Exception ex) {
      carsServiceIsRunning = false;
    }

    Assumptions.assumeTrue(carsServiceIsRunning);
    assertThat(car.toString().contains("Mazda"));
  }  

}
