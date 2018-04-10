package com.springboot.controller;

import com.springboot.domain.Car;
import com.springboot.domain.CustomType;
import com.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// 跨域
@CrossOrigin(origins = "http://127.0.0.1:8080", maxAge = 3600)
@RequestMapping("/api")
public class CarRestController {
  @Autowired
  private CarService carService;

  /*
  @RequestMapping(value = "/cars", method = RequestMethod.GET)
  public ResponseEntity<?> getCars() {
    List<Car> cars = carService.list();

    if (cars.isEmpty()) {
      return new ResponseEntity<>(new CustomType(400, "没有匹配的结果!"), HttpStatus.OK);
    }

    return new ResponseEntity<>(cars, HttpStatus.OK);
  }*/

  @RequestMapping(value = "/cars", method = RequestMethod.GET)
  public ResponseEntity<?> getCars(
      @RequestParam(value = "name", required = false) String name
  ) {
    List<Car> cars = carService.list(name);

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

  @RequestMapping(value = "/cars", method = RequestMethod.POST)
  public ResponseEntity<?> add(@RequestBody Car car) {
    int count = carService.add(car);
    return new ResponseEntity<>(count, HttpStatus.OK);
  }

  @RequestMapping(value = "/cars", method = RequestMethod.PUT)
  public ResponseEntity<?> modify(@RequestBody Car car) {
    int count = carService.modify(car);
    return new ResponseEntity<>(count, HttpStatus.OK);
  }

  @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
    int count = carService.remove(id);
    return new ResponseEntity<>(count, HttpStatus.OK);
  }
}
