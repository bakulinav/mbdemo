package dev.abakulin;

import dev.abakulin.mbapi.model.*;
import dev.abakulin.model.VehicleState;

public class VehicleStateDelta {
    boolean compare(VehicleState base, VehicleState latest) {
        return compareVehicle(base.getVehicle(), latest.getVehicle())
            || compareTires(base.getTires(), latest.getTires())
            || compareDoors(base.getDoors(), latest.getDoors())
            || compareFuel(base.getFuel(), latest.getFuel())
            || compareLocation(base.getLocation(), latest.getLocation())
            || compareCharge(base.getCharge(), latest.getCharge())
            || compareDistance(base.getDistance(), latest.getDistance());
    }

    private boolean compareVehicle(VehicleDetail base, VehicleDetail latest) {
        return false;
    }
    
    private boolean compareTires(Tires base, Tires latest) {
        return false;
    }
    
    private boolean compareDoors(Doors base, Doors latest) {
        return false;
    }

    private boolean compareFuel(FuelLevel base, FuelLevel latest) {
        return false;
    }

    private boolean compareLocation(Location base, Location latest) {
        return false;
    }

    private boolean compareCharge(StateOfCharge base, StateOfCharge latest) {
        return false;
    }

    private boolean compareDistance(DistanceDriven base, DistanceDriven latest) {
        return false;
    }
}
