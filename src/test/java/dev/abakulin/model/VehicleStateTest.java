package dev.abakulin.model;

import dev.abakulin.mbapi.model.*;
import junit.framework.TestCase;

public class VehicleStateTest extends TestCase {

    public void testHasNoUpdate() {
        VehicleState current = getSimpleState();
        VehicleState change = getSimpleState();

        boolean diff = current.hasUpdate(change);

        assertFalse("states have no differences", diff);
    }

    public void testHasDetailsUpdate() {
        VehicleState current = getSimpleState();
        VehicleState change = getSimpleState();
        change.getVehicle().colorname("red");

        boolean diff = current.hasUpdate(change);

        assertTrue("states different by details", diff);
    }

    public void testHasTiresUpdate() {
        VehicleState current = getSimpleState();
        VehicleState change = getSimpleState();
        change.getTires().getTirepressurefrontleft().setValue(100.0);

        boolean diff = current.hasUpdate(change);

        assertTrue("states different in tires", diff);
    }

    public void testHasDoorsUpdate() {
        VehicleState current = getSimpleState();
        VehicleState change = getSimpleState();
        change.getDoors().getDoorlockstatusfrontleft().setValue(DoorLockStatus.ValueEnum.LOCKED);

        boolean diff = current.hasUpdate(change);

        assertTrue("states different in doors", diff);
    }

    public void testHasFuelUpdate() {
        VehicleState current = getSimpleState();
        VehicleState change = getSimpleState();
        change.getFuel().setValue(10);

        boolean diff = current.hasUpdate(change);

        assertTrue("states different in fuel level", diff);
    }

    public void testHasLocationUpdate() {
        VehicleState current = getSimpleState();
        VehicleState change = getSimpleState();
        change.getLocation().setLongitude(new LocationCoordinate());

        boolean diff = current.hasUpdate(change);

        assertTrue("states different in location", diff);
    }

    public void testHasChargeUpdate() {
        VehicleState current = getSimpleState();
        VehicleState change = getSimpleState();
        change.getCharge().setValue(20);

        boolean diff = current.hasUpdate(change);

        assertTrue("states different in state of charge", diff);
    }

    public void testHasDistanceUpdate() {
        VehicleState current = getSimpleState();
        VehicleState change = getSimpleState();
        change.getDistance().setValue(150);

        boolean diff = current.hasUpdate(change);

        assertTrue("states different in distance", diff);
    }

    private VehicleState getSimpleState() {
        return VehicleState.builder()
                .vehicle(getSimpleVehicle())
                .tires(getTires())
                .doors(getDoors())
                .fuel(getFuel())
                .location(getLocation())
                .charge(getCharge())
                .distance(getDistance())
                .build();
    }

    private VehicleDetail getSimpleVehicle() {
        return new VehicleDetail();
    }

    private Tires getTires() {
        Tires tires = new Tires();
        tires.setTirepressurefrontleft(new TirePressureStatus());
        tires.setTirepressurefrontright(new TirePressureStatus());
        tires.setTirepressurerearleft(new TirePressureStatus());
        tires.setTirepressurerearright(new TirePressureStatus());

        return tires;
    }

    private Doors getDoors() {
        Doors doors = new Doors();
        doors.setDoorlockstatusvehicle(new DoorLockStatus());
        doors.setDoorlockstatusfrontleft(new DoorLockStatus());
        doors.setDoorlockstatusfrontright(new DoorLockStatus());
        doors.setDoorlockstatusrearleft(new DoorLockStatus());
        doors.setDoorlockstatusrearright(new DoorLockStatus());
        doors.setDoorlockstatusgas(new DoorLockStatus());
        doors.setDoorlockstatusdecklid(new DoorLockStatus());

        return doors;
    }

    private FuelLevel getFuel() {
        return new FuelLevel();
    }

    private Location getLocation() {
        return new Location();
    }

    private StateOfCharge getCharge() {
        return new StateOfCharge();
    }

    private DistanceDriven getDistance() {
        return new DistanceDriven();
    }
}