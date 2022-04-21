package com.cybertek;

import com.cybertek.entity.Car;
import com.cybertek.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Spring09OrmTableCreationApplication {

    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmTableCreationApplication.class, args);
    }

    @PostConstruct
    public void dataInit(){

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("BMW", "M3"));
        cars.add(new Car("AUDI", "Q5"));
        cars.add(new Car("BMW", "M7"));
        cars.add(new Car("KIA", "Sanata"));

        carRepository.saveAll(cars);

        Car car1 = new Car("BMW", "M5");
        Car car2 = new Car("AUDI", "Q7");
        Car car3 = new Car("BMW", "M3");
        Car car4 = new Car("KIA", "Sorento");

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);

    }

}
