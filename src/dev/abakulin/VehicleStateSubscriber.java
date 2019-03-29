package dev.abakulin;

import dev.abakulin.model.VehicleState;

public interface VehicleStateSubscriber {
    void applyUpdate(VehicleState updatedState);
}
