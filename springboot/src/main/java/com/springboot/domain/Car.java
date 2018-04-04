package com.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Car {
  private Integer id;
  private String name;
  private Double price;

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date createDate;

  public Car() {
  }

  public Car(Integer id, String name, Double price, Date createDate) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.createDate = createDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
}
