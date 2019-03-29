package dev.abakulin;

import dev.abakulin.mbapi.ApiClient;
import dev.abakulin.mbapi.ApiException;
import dev.abakulin.mbapi.Configuration;
import dev.abakulin.mbapi.api.*;
import dev.abakulin.mbapi.auth.Authentication;
import dev.abakulin.mbapi.auth.OAuth;
import dev.abakulin.mbapi.model.DoorOpenStatus;
import dev.abakulin.mbapi.model.Doors;
import dev.abakulin.mbapi.model.VehicleDetail;
import dev.abakulin.mbapi.model.Vehicles;

import java.util.Map;

public class Main {



    public static void main(String[] args) throws Exception {
        OAuth oAuth = new OAuth();
        // use postman to get access token
//        oAuth.setAccessToken("8cc86d86-b528-4db6-ba6a-b3dfb9fc9848");
        oAuth.setAccessToken("26db506c-6d0c-444c-a2c9-7536e314b396");

        ApiClient mbApiClient = Configuration.getDefaultApiClient();
        Map<String, Authentication> auths = mbApiClient.getAuthentications();
        auths.put("oauth2", oAuth);

        VehiclesApi vehiclesApi = new VehiclesApi(mbApiClient);
        Vehicles allVehicles = vehiclesApi.getAllVehicles();

        DoorsApi doorsApi = new DoorsApi(mbApiClient);

        allVehicles.forEach(v -> {
            System.out.println(v);

            try {
                VehicleDetail vehicle = vehiclesApi.getVehicleById(v.getId());
                System.out.println(String.format("Vehicle details: %s", vehicle));
            } catch (ApiException ex) {
                System.out.println(String.format("Error: Fail to get vehicle details for vehicle ID %s: %s", v.getId(), ex.getResponseBody()));
            }

//            checkApiStatus(v.getId(), mbApiClient);

            System.out.println("Getting doors status:");
            try {
                Doors doorsStatus = doorsApi.getDoorsStatus(v.getId());
                DoorOpenStatus doorFrontLeft = doorsStatus.getDoorstatusfrontleft();
                System.out.println(String.format("Front left door: %s", doorFrontLeft.getValue()));

                DoorOpenStatus doorFrontRight = doorsStatus.getDoorstatusfrontright();
                System.out.println(String.format("Front right door: %s", doorFrontRight.getValue()));
            } catch (ApiException ex) {
                System.out.println(String.format("Error: Fail to get doors status for vehicle ID %s: %s", v.getId(), ex.getResponseBody()));
            }
        });
    }

    public static void checkApiStatus(String vehicleID, ApiClient apiClient) {
        System.out.print("Checking vehicles API: ");
        VehiclesApi vehiclesApi = new VehiclesApi(apiClient);
        try {
            vehiclesApi.getVehicleById(vehicleID);
            System.out.println("AVAILABE");
        } catch (ApiException ex) {
            System.out.println("UNAVAILABE");
        }

        System.out.print("Checking doors API: ");
        DoorsApi doorsApi = new DoorsApi(apiClient);
        try {
            doorsApi.getDoorsStatus(vehicleID);
            System.out.println("AVAILABE");
        } catch (ApiException ex) {
            System.out.println("UNAVAILABE");
        }

        System.out.print("Checking fuel API: ");
        FuelApi fuelApi = new FuelApi(apiClient);
        try {
            fuelApi.getFuelLevel(vehicleID);
            System.out.println("AVAILABE");
        } catch (ApiException ex) {
            System.out.println("UNAVAILABE");
        }

        System.out.print("Checking location API: ");
        LocationApi locationApi = new LocationApi(apiClient);
        try {
            locationApi.getLocation(vehicleID);
            System.out.println("AVAILABE");
        } catch (ApiException ex) {
            System.out.println("UNAVAILABE");
        }

        System.out.print("Checking odometer API: ");
        OdometerApi odometerApi = new OdometerApi(apiClient);
        try {
            odometerApi.getOdometerStatus(vehicleID);
            System.out.println("AVAILABE");
        } catch (ApiException ex) {
            System.out.println("UNAVAILABE");
        }

        System.out.print("Checking stateOfCharge API: ");
        StateOfChargeApi stateOfChargeApi = new StateOfChargeApi(apiClient);
        try {
            stateOfChargeApi.getStateOfCharge(vehicleID);
            System.out.println("AVAILABE");
        } catch (ApiException ex) {
            System.out.println("UNAVAILABE");
        }

        System.out.print("Checking tires API: ");
        TiresApi tiresApi = new TiresApi(apiClient);
        try {
            tiresApi.getTiresStatus(vehicleID);
            System.out.println("AVAILABE");
        } catch (ApiException ex) {
            System.out.println("UNAVAILABE");
        }
    }
}
