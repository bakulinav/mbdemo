/*
 * Experimental Connected Vehicle API
 * An experimental Connected Vehicle API that allows to request vehicle data and to send commands to the virtual car simulator.
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package dev.abakulin.mbapi.api;

import dev.abakulin.mbapi.ApiException;
import dev.abakulin.mbapi.model.ErrorResponse;
import dev.abakulin.mbapi.model.StateOfCharge;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for StateOfChargeApi
 */
@Ignore
public class StateOfChargeApiTest {

    private final StateOfChargeApi api = new StateOfChargeApi();

    
    /**
     * Provides the current status of the battery pack.
     *
     * Provides the current status of the battery pack.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStateOfChargeTest() throws ApiException {
        String vehicleId = null;
        StateOfCharge response = api.getStateOfCharge(vehicleId);

        // TODO: test validations
    }
    
}
