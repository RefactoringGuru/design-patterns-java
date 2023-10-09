package refactoring_guru.builder.example.cars;

import refactoring_guru.builder.example.components.Engine;
import refactoring_guru.builder.example.components.GPSNavigator;
import refactoring_guru.builder.example.components.Transmission;
import refactoring_guru.builder.example.components.TripComputer;

/**
 * EN: Car manual is another product. Note that it does not have the same
 * ancestor as a Car. They are not related.
 * <p>
 * RU: Руководство автомобиля — это второй продукт. Заметьте, что руководство и
 * сам автомобиль не имеют общего родительского класса. По сути, они независимы.
 */
public class Manual {
  private final CarType carType;
  private final int seats;
  private final Engine engine;
  private final Transmission transmission;
  private final TripComputer tripComputer;
  private final GPSNavigator gpsNavigator;

  public Manual(CarType carType, int seats, Engine engine, Transmission transmission,
                TripComputer tripComputer, GPSNavigator gpsNavigator) {
    this.carType = carType;
    this.seats = seats;
    this.engine = engine;
    this.transmission = transmission;
    this.tripComputer = tripComputer;
    this.gpsNavigator = gpsNavigator;
  }

  public String print() {
    return String.join("\n",
            "Type of car: " + carType,
            "Count of seats: " + seats,
            "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage(),
            "Transmission: " + transmission,
            "Trip Computer: " + (tripComputer != null ? "Functional" : "N/A"),
            "GPS Navigator: " + (gpsNavigator != null ? "Functional" : "N/A")
    );
  }
}
