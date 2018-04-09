package com.springboot.domain;

import java.io.Serializable;

public class CustomType implements Serializable {
  private static final long serialVersionUID = -8830428430110582225L;
  private Integer code;
  private String message;

  public CustomType() {
  }

  public CustomType(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
