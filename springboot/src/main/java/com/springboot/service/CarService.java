package com.springboot.service;

import com.springboot.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CarService {

  public List<Car> list() {
    List<Car> cars = new ArrayList<>();
    Car car = new Car();
    car.setId(1);
    car.setName("Benz");
    car.setPrice(8989d);
    car.setCreateDate(new Date());
    cars.add(car);

    cars.add(new Car(2, "BMW", 9999d, new Date()));
    cars.add(new Car(3, "Audi", 6669d, new Date()));
    cars.add(new Car(4, "Golf", 5559d, new Date()));
    cars.add(new Car(5, "Ford", 7779d, new Date()));
    cars.add(new Car(6, "VW", 8889d, new Date()));

    return cars;
  }
}
