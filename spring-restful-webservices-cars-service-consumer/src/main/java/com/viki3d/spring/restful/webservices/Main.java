package com.viki3d.spring.restful.webservices;

import com.viki3d.spring.restful.webservices.front.api.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * The default SpringBoot configuration class.
 */
@SpringBootApplication
public class Main {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * The entry point of this SpringBoot application.
   *
   * @param args The command line parameters passed to this application. Currently no such 
   *     parameters are supported by this application.
   */
  public static void main(String[] args) {

    // Get the Spring Context
    ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

    // Ensures a graceful shutdown and calls the relevant destroy methods on your singleton 
    // beans so that all resources are released.
    context.registerShutdownHook();

  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  /**
   * Runs when SpringBoot application runs due CommandLineRunner interface.
   */
  @Bean
  public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
    // Local variable names are written in lowerCamelCase [...] Even when final and immutable, local
    // variables are not considered to be constants, and should not be styled as constants.
    final String url = "http://localhost:8080/api/v1/cars/1";
    return args -> {
      try {
        Car car = restTemplate.getForObject(url, Car.class);
        logger.debug(car.toString());
      } catch (Exception ex) {
        logger.error(ex.getMessage());
        logger.error("Check if [cars-service] is running!");
      }
    };
  }  
  
}
