package dev.abakulin;

import dev.abakulin.mbapi.ApiClient;
import dev.abakulin.mbapi.ApiException;
import dev.abakulin.mbapi.api.*;
import dev.abakulin.mbapi.model.*;
import dev.abakulin.model.VehicleState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VehicleStateWatcher {

    private static final Logger logger = LoggerFactory.getLogger(VehicleStateWatcher.class);

    VehicleState currentState = new VehicleState();
    Long checkStateIntervalMs;

    List<VehicleStateSubscriber> subscribers = new ArrayList<>();

    private String vehicleId = null;

    final ApiClient mbClient;
    private final VehiclesApi vehiclesApi;
    private final TiresApi tiresApi;
    private final DoorsApi doorsApi;
    private final FuelApi fuelApi;
    private final LocationApi locationApi;
    private final StateOfChargeApi chargeApi;
    private final OdometerApi distanceApi;

    public VehicleStateWatcher(ApiClient mbClient, Long checkIntervalMs) {
        this.mbClient = mbClient;
        this.checkStateIntervalMs = checkIntervalMs;

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

        Optional<VehicleState> change;
        logger.info("Checking state with interval {}ms", checkStateIntervalMs);
        // loop watching vehicle state
        while (true) {
            try {
                Thread.sleep(checkStateIntervalMs);
            } catch (InterruptedException ex) {
                logger.error("VehicleStateWatcher thread interrupted");
                break;
            }

            try {
                logger.info("Checking vehicle {} state...", vehicleId);
                change = getVehicleState();
            } catch (ApiException  ex) {
                logger.error("Fail to get recent state of vehicle {}. Skip next interval", vehicleId);
                change = Optional.empty();
                try {
                    Thread.sleep(checkStateIntervalMs);
                } catch (InterruptedException e) {
                    logger.error("VehicleStateWatcher thread interrupted");
                    break;
                }
            }

            if (change.isPresent()) {
                logger.info("Check Vehicle state for changes");
                // if state changed, notify subscribers

                if (hasUpdates(change.get())) {
                    logger.info("Vehicle has updates");
                    Optional<VehicleState> finalChange = change;
                    subscribers.forEach(it -> it.applyUpdate(finalChange.get()));
                    currentState = updateState(change.get());
                } else {
                    logger.info("Vehicle has no changes");
                }
            }
        }
    }

    private boolean hasUpdates(VehicleState vehicleState) {
        VehicleStateDelta vehicleStateDelta = new VehicleStateDelta();

        return vehicleStateDelta.compare(currentState, vehicleState);
    }

    private Optional<VehicleState> getVehicleState() throws ApiException {
        logger.info("Getting vehicle {} state", vehicleId);

        VehicleDetail vehicle = getVehicle();
        Tires tires = getTires();
        Doors doors = getDoors();
        FuelLevel fuel = getFuel();
        Location location = getLocation();
        StateOfCharge charge = getCharge();
        DistanceDriven distance = getDistance();

        return Optional.of(new VehicleState(vehicle, tires, doors, fuel, location, charge, distance));
    }

    private void initState() {
        logger.info("Init state of vehicle {}", vehicleId);

        Optional<VehicleState> latestState;
        try {
            latestState = getVehicleState();
        } catch (ApiException ex) {
            logger.warn("Fail to get recent vehicle state", ex);
            latestState = Optional.empty();
        }

        if (latestState.isPresent()) {
            logger.info("Merge empty state with new get for vehicle {}", vehicleId);
            currentState.merge(latestState.get());
        }

        logger.info("Current state of vehicle {}: {}", vehicleId, currentState.toString());
    }

    private VehicleDetail getVehicle() throws ApiException {
        logger.info("Getting vehicle {} details", vehicleId);
        try {
            return vehiclesApi.getVehicleById(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init vehicle state over API for vehicle {}", vehicleId);
            throw ex;
        }
    }

    private Tires getTires() throws ApiException {
        logger.info("Getting vehicle {} tires", vehicleId);
        try {
            return tiresApi.getTiresStatus(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init tires state over API for vehicle {}", vehicleId);
            throw ex;
        }
    }

    private Doors getDoors() throws ApiException {
        logger.info("Getting vehicle {} doors", vehicleId);
        try {
            return doorsApi.getDoorsStatus(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init doors state over API for vehicle {}", vehicleId);
            throw ex;
        }
    }

    private FuelLevel getFuel() throws ApiException {
        logger.info("Getting vehicle {} fuel level", vehicleId);
        try {
            return fuelApi.getFuelLevel(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init fuel level state over API for vehicle {}", vehicleId);
            throw ex;
        }
    }

    private Location getLocation() throws ApiException {
        logger.info("Getting vehicle {} location", vehicleId);
        try {
            return locationApi.getLocation(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init location state over API for vehicle {}", vehicleId);
            throw ex;
        }
    }

    private StateOfCharge getCharge() throws ApiException {
        logger.info("Getting vehicle {} state of charge", vehicleId);
        try {
            return chargeApi.getStateOfCharge(vehicleId);
        } catch (ApiException ex) {
            logger.error("Fail init state of charge over API for vehicle {}", vehicleId);
            throw ex;
        }
    }

    private DistanceDriven getDistance() throws ApiException {
        logger.info("Getting vehicle {} distance driven", vehicleId);
        try {
            return distanceApi.getOdometerStatus(vehicleId).getDistancesincereset();
        } catch (ApiException ex) {
            logger.error("Fail init distance driven over API for vehicle {}", vehicleId);
            throw ex;
        }
    }

    private VehicleState updateState(VehicleState recent) {
        if (currentState.equals(recent)) {
            logger.info("State for vehicle {} doesn't change", vehicleId);
        } else {
            logger.info("Update vehicle {} state with latest", vehicleId);
            return currentState.merge(recent);
        }

        return currentState;
    }
}
