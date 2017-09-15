package refactoring_guru.builder.example.components;

import refactoring_guru.builder.example.cars.Car;

/**
 * EN: Just another feature of a car.
 * 
 * RU: Одна из фишек автомобиля.
 */
public class TripComputer {

    public void condition() {
        if (Engine.isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }

    public void fuelLevel() {
        System.out.println("Level of fuel - " + Car.getFuel());
    }
}
