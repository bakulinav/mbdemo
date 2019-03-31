package dev.abakulin;

import dev.abakulin.mbapi.ApiClient;
import dev.abakulin.mbapi.ApiException;
import dev.abakulin.mbapi.api.*;
import dev.abakulin.mbapi.model.*;
import dev.abakulin.model.VehicleState;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VehicleStateWatcher {

    private static final Logger logger = LoggerFactory.getLogger(VehicleStateWatcher.class);

    VehicleState currentState = new VehicleState();
    Long checkStateIntervalMs = 5000L;

    List<VehicleStateSubscriber> subscribers;

    private String vehicleId = null;

    final ApiClient mbClient;
    private final VehiclesApi vehiclesApi;
    private final TiresApi tiresApi;
    private final DoorsApi doorsApi;
    private final FuelApi fuelApi;
    private final LocationApi locationApi;
    private final StateOfChargeApi chargeApi;
    private final OdometerApi distanceApi;

    public VehicleStateWatcher(ApiClient mbClient) {
        this.mbClient = mbClient;

        this.vehiclesApi = new VehiclesApi(mbClient);
        this.tiresApi = new TiresApi(mbClient);
        this.doorsApi = new DoorsApi(mbClient);
        this.fuelApi = new FuelApi(mbClient);
        this.locationApi = new LocationApi(mbClient);
        this.chargeApi = new StateOfChargeApi(mbClient);
        this.distanceApi = new OdometerApi(mbClient);
    }

    public void watchingForVehicle(String id) {
        if (vehicleId == null) {
            vehicleId = id;
        } else {
            if (vehicleId.equals(id)) {
                logger.warn("Vehicle {} is already watching for", id);
            } else {
                logger.error("Can't init watcher for {}, it's already busy for other vehicle", id);
            }
            return;
        }

        loopStateCheck();
    }

    VehicleState getCurrentState() {
        return currentState;
    }

    void subscribeVehicleState(VehicleStateSubscriber subscriber) {
        boolean added = subscribers.add(subscriber);
    }

    void unSubscribeVehicleState(VehicleStateSubscriber subscriber) {
        boolean removed = subscribers.remove(subscriber);
    }

    private void loopStateCheck() {
        // get init state
        initState();

        logger.info("Checking state with interval {}ms", checkStateIntervalMs);
        // loop watching vehicle state
        while (true) {
            logger.info("Checking vehicle {} state...", vehicleId);
            Optional<VehicleState> change = checkState();

            if (change.isPresent()) {
                logger.info("Vehicle state changed");
                // if state changed, notify subscribers
                subscribers.forEach(it -> it.applyUpdate(change.get()));
                currentState = updateState(change.get());
            }
            try {
                Thread.sleep(checkStateIntervalMs);
            } catch (InterruptedException ex) {
                logger.error("VehicleStateWatcher thread interrupted");
                break;
            }
        }
    }

    private Optional<VehicleState> checkState() {
        VehicleDetail vehicle = getVehicle();
        Tires tires = getTires();
        Doors doors = getDoors();
        FuelLevel fuel = getFuel();
        Location location = getLocation();
        StateOfCharge charge = getCharge();
        DistanceDriven distance = getDistance();

        logger.info("Merge current state with new get for vehicle {}", vehicleId);
        return Optional.of(new VehicleState(vehicle, tires, doors, fuel, location, charge, distance));
    }

    private void initState() {
        logger.info("Init state of vehicle {}", vehicleId);

        VehicleDetail vehicle = getVehicle();
        Tires tires = getTires();
        Doors doors = getDoors();
        FuelLevel fuel = getFuel();
        Location location = getLocation();
        StateOfCharge charge = getCharge();
        DistanceDriven distance = getDistance();

        logger.info("Merge empty state with new get for vehicle {}", vehicleId);
        VehicleState recentState = new VehicleState(vehicle, tires, doors, fuel, location, charge, distance);
        currentState.merge(recentState);

        logger.info("Current state of vehicle {}: {}", vehicleId, currentState.toString());
    }

    private VehicleDetail getVehicle() {
        logger.info("Getting vehicle {} details", vehicleId);
        try {
            return vehiclesApi.getVehicleById(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init vehicle state over API for vehicle {}", vehicleId);
            throw new WatcherException("Fail init vehicle state over API", ex);
        }
    }

    private Tires getTires() {
        logger.info("Getting vehicle {} tires", vehicleId);
        try {
            return tiresApi.getTiresStatus(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init tires state over API for vehicle {}", vehicleId);
            throw new WatcherException("Fail init tires state over API", ex);
        }
    }

    private Doors getDoors() {
        logger.info("Getting vehicle {} doors", vehicleId);
        try {
            return doorsApi.getDoorsStatus(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init doors state over API for vehicle {}", vehicleId);
            throw new WatcherException("Fail init doors state over API", ex);
        }
    }

    private FuelLevel getFuel() {
        logger.info("Getting vehicle {} fuel level", vehicleId);
        try {
            return fuelApi.getFuelLevel(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init fuel level state over API for vehicle {}", vehicleId);
            throw new WatcherException("Fail init fuel level state over API", ex);
        }
    }

    private Location getLocation() {
        logger.info("Getting vehicle {} location", vehicleId);
        try {
            return locationApi.getLocation(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init location state over API for vehicle {}", vehicleId);
            throw new WatcherException("Fail init location state over API", ex);
        }
    }

    private StateOfCharge getCharge() {
        logger.info("Getting vehicle {} state of charge", vehicleId);
        try {
            return chargeApi.getStateOfCharge(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init state of charge over API for vehicle {}", vehicleId);
            throw new WatcherException("Fail init state of charge over API", ex);
        }
    }

    private DistanceDriven getDistance() {
        logger.info("Getting vehicle {} distance driven", vehicleId);
        try {
            return distanceApi.getOdometerStatus(vehicleId).getDistancesincereset();
        } catch (ApiException ex) {
            logger.error("Fail init distance driven over API for vehicle {}", vehicleId);
            throw new WatcherException("Fail init distance driven state over API", ex);
        }
    }

    private VehicleState updateState(VehicleState recent) {
        if (currentState == recent) {
            logger.info("State for vehicle {} doesn't change", vehicleId);
        } else {
            logger.info("Update vehicle {} state with recent {}", vehicleId, recent);
            return currentState.merge(recent);
        }

        return currentState;
    }
}
