package com.example.testtask.controller;

import com.example.testtask.dto.CarDto;
import com.example.testtask.exception.DriversLicenseException;
import com.example.testtask.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public CarDto getCar(@PathVariable Long id) throws DriversLicenseException {
        return carService.getCar(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<CarDto> getCars() {
        return carService.getCars();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCar(@RequestBody CarDto carDto) {
        carService.addCar(carDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCar(@PathVariable Long id, @RequestBody CarDto car) {
        carService.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

}