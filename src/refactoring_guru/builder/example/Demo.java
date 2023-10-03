package refactoring_guru.builder.example;

import refactoring_guru.builder.example.builders.CarBuilder;
import refactoring_guru.builder.example.builders.CarManualBuilder;
import refactoring_guru.builder.example.cars.Car;
import refactoring_guru.builder.example.cars.Manual;
import refactoring_guru.builder.example.director.Director;

/**
 * EN: Demo class. Everything comes together here.
 * EN: Director gets the concrete builder object from the client
 * (application code). That's because the application knows better which
 * builder to use to get a specific product.
 * <p>
 * RU: Демо-класс. Здесь всё сводится воедино.
 * RU: Директор получает объект конкретного строителя от клиента
 * (приложения). Приложение само знает какой строитель использовать,
 * чтобы получить нужный продукт.
 */
public class Demo {

  public static void main(String[] args) {
    Director director = new Director();

    CarBuilder builder = new CarBuilder();
    director.constructSportsCar(builder);

    Car car = builder.getResult();
    System.out.println("Car built:\n" + car.getCarType());


    CarManualBuilder manualBuilder = new CarManualBuilder();
    director.constructSportsCar(manualBuilder);
    Manual carManual = manualBuilder.getResult();
    System.out.println("\nCar manual built:\n" + carManual.print());
  }
}
