package dev.abakulin.model;

import dev.abakulin.mbapi.model.*;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

/**
 * Represents the state of vehicle in specific time
 */
@Getter
@Builder
public class VehicleState {
    VehicleDetail vehicle;
    Tires tires;
    Doors doors;
    FuelLevel fuel;
    Location location;
    StateOfCharge charge;
    DistanceDriven distance;

    public VehicleState() {
    }

    public VehicleState(VehicleDetail vehicle, Tires tires, Doors doors, FuelLevel fuel, Location location, StateOfCharge charge, DistanceDriven distance) {
        this.vehicle = vehicle;
        this.tires = tires;
        this.doors = doors;
        this.fuel = fuel;
        this.location = location;
        this.charge = charge;
        this.distance = distance;
    }

    public VehicleState merge(VehicleState change) {
        VehicleState merged = new VehicleState();

        this.vehicle = mergeVehicle(this.vehicle, change.vehicle);
        this.tires = mergeTires(this.tires, change.tires);
        this.doors = mergeDoors(this.doors, change.doors);
        this.fuel = mergeFuel(this.fuel, change.fuel);
        this.location = mergeLocation(this.location, change.location);
        this.charge = mergeCharge(this.charge, change.charge);
        this.distance = mergeDistance(this.distance, change.distance);

        // current fields + updated "change" fields

        return merged;
    }

    public boolean hasUpdate(VehicleState change) {

        // current fields + updated "change" fields

        return !this.equals(change);
    }

    private VehicleDetail mergeVehicle(VehicleDetail fromDetails, VehicleDetail toDetails) {
        return toDetails == null ? fromDetails : toDetails;
    }

    private Tires mergeTires(Tires fromTires, Tires toTires) {
        return toTires == null ? fromTires : toTires;
    }

    private Doors mergeDoors(Doors fromDoors, Doors toDoors) {
        return toDoors == null ? fromDoors : toDoors;
    }

    private FuelLevel mergeFuel(FuelLevel fromFuel, FuelLevel toFuel) {
        return toFuel == null ? fromFuel : toFuel;
    }

    private Location mergeLocation(Location fromLocation, Location toLocation) {
        return toLocation == null ? fromLocation : toLocation;
    }

    private StateOfCharge mergeCharge(StateOfCharge fromCharge, StateOfCharge toCharge) {
        return toCharge == null ? fromCharge : toCharge;
    }

    private DistanceDriven mergeDistance(DistanceDriven fromDistance, DistanceDriven toDistance) {
        return toDistance == null ? fromDistance : toDistance;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VehicleState vehicleState = (VehicleState) o;
        return Objects.equals(this.vehicle, vehicleState.vehicle) &&
                Objects.equals(this.tires, vehicleState.tires) &&
                Objects.equals(this.doors, vehicleState.doors) &&
                Objects.equals(this.fuel, vehicleState.fuel) &&
                Objects.equals(this.location, vehicleState.location) &&
                Objects.equals(this.charge, vehicleState.charge) &&
                Objects.equals(this.distance, vehicleState.distance);
    }

    @Override
    public String toString() {
        return "VehicleState{" +
                "vehicle=" + vehicle +
                ", tires=" + tires +
                ", doors=" + doors +
                ", fuel=" + fuel +
                ", location=" + location +
                ", charge=" + charge +
                ", distance=" + distance +
                '}';
    }
}
