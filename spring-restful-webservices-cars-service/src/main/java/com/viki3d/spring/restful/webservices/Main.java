package com.viki3d.spring.restful.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * The default SpringBoot configuration class.
 */
@SpringBootApplication
public class Main {

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

}
