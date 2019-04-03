package dev.abakulin;

import dev.abakulin.mbapi.ApiClient;
import dev.abakulin.mbapi.Configuration;
import dev.abakulin.mbapi.api.*;
import dev.abakulin.mbapi.auth.OAuth;
import dev.abakulin.mbapi.model.Vehicles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        logger.info("Start application");

        ApiClient mbApiClient = Configuration.getDefaultApiClient();
        OAuth oauth2 = (OAuth) mbApiClient.getAuthentication("oauth2");
        oauth2.setAccessToken("");

        VehiclesApi vehiclesApi = new VehiclesApi(mbApiClient);
        Vehicles allVehicles = vehiclesApi.getAllVehicles();


        VehicleStateWatcher vehicleStateWatcher = new VehicleStateWatcher(mbApiClient, 20000L);


        allVehicles.forEach(v -> {
            System.out.println(v);
            logger.info("Watching for vehicle with ID {}", v.getId());

            vehicleStateWatcher.watchingForVehicle(v.getId());
        });
    }
}
