package com.viki3d.spring.restful.webservices.front.controllers.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CarsRestControllerTests {
  
  @Autowired
  private MockMvc mockMvc;
  
  @Test
  void testServiceIsUp() throws Exception {
    this.mockMvc.perform(get("/api/v1/cars")).andDo(print()).andExpect(status().isOk());
  }
}
