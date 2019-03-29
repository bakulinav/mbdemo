package dev.abakulin.model;

import dev.abakulin.mbapi.model.*;

/**
 * Represents the state of vehicle in specific time
 */
public class VehicleState {
    Vehicle vehicle;
    VehicleDetail details;
    Tires tires;
    Doors doors;
    FuelLevel fuel;
    Location location;
    StateOfCharge charge;
    DistanceDriven distance;

    public VehicleState merge(VehicleState change) {
        VehicleState merged = new VehicleState();

        // current fields + updated "change" fields

        return merged;
    }
}
