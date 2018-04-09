package com.springboot.controller;

import com.springboot.domain.Car;
import com.springboot.domain.CustomType;
import com.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {
  @Autowired
  private CarService carService;

  @RequestMapping(value = "/cars", method = RequestMethod.GET)
  public ResponseEntity<?> getCars() {
    List<Car> cars = carService.list();

    if (cars.isEmpty()) {
      return new ResponseEntity<>(new CustomType(400, "没有匹配的结果!"), HttpStatus.OK);
    }

    return new ResponseEntity<>(cars, HttpStatus.OK);
  }

  @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
  public ResponseEntity<?> getCar(@PathVariable("id") Integer id) {
    Car car = carService.find(id);

    if (car == null) {
      return new ResponseEntity<>(new CustomType(400, id + " 没有匹配的结果!"), HttpStatus.OK);
    }

    return new ResponseEntity<>(car, HttpStatus.OK);
  }
}
