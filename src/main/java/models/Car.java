package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.module.ModuleReference;

//@AllArgsConstructor
//@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Car {
    private String location;
    private String make;
    private String model;
    private String year;
    private String engine;
    private String fuel;
    private String gear;
    private String wD;
    private String doors;
    private String seats;
    private String clasS;
    private String fuelConsumption;
    private String carRegistrationNumber;
    private String price;
    private String distanceIncluded;
    private String features;
    private String about;

}
