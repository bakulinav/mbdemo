package dev.abakulin;

import dev.abakulin.model.VehicleState;

import java.util.List;
import java.util.Optional;

public class VehicleStateWatcher {
    VehicleState currentState = new VehicleState();

    List<VehicleStateSubscriber> subscribers;

    VehicleState getCurrentState() {
        return currentState;
    }

    void subscribeVehicleState(VehicleStateSubscriber subscriber) {
        boolean added = subscribers.add(subscriber);
    }

    void unSubscribeVehicleState(VehicleStateSubscriber subscriber) {
        boolean removed = subscribers.remove(subscriber);
    }

    void loopStateCheck() {
        // get init state
        currentState = initState();

        // loop watching vehicle state
        while (true) {
            Optional<VehicleState> change = checkState();

            if (change.isPresent()) {
                // if state changed, notify subscribers
                subscribers.forEach(it -> it.applyUpdate(change.get()));
                currentState = updateState(change.get());
            }
        }
    }

    private Optional<VehicleState> checkState() {
        return Optional.empty();
    }

    private VehicleState initState() {
        return new VehicleState();
    }

    private VehicleState updateState(VehicleState change) {
        return currentState.merge(change);
    }

}
