package com.viki3d.spring.restful.webservices.front.api.model;

/**
 * Representing car instances.
 *
 * @author User
 */
public class Car {

  private long id;
  private String brand;
  private String model;
  private String color;
  
  public Car() {

  }
  
  /**
   * Constructs a specific car.
   *
   * @param brand Car's brand.
   * @param model Car's model.
   * @param color Car's color.
   */
  public Car(long id, String brand, String model, String color) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.color = color;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
  
  @Override
  public String toString() {
    return "car:["
        + "id = " + id
        + ", brand = " + brand
        + ", model = " + model
        + ", color = " + color
        + "]";
  }
}
