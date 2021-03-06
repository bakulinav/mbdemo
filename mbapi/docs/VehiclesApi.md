# VehiclesApi

All URIs are relative to *https://api.mercedes-benz.com/experimental/connectedvehicle/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllVehicles**](VehiclesApi.md#getAllVehicles) | **GET** /vehicles | Find all vehicles.
[**getVehicleById**](VehiclesApi.md#getVehicleById) | **GET** /vehicles/{vehicleId} | Get vehicle by ID.


<a name="getAllVehicles"></a>
# **getAllVehicles**
> Vehicles getAllVehicles()

Find all vehicles.

List all of the user&#39;s vehicles.

### Example
```java
// Import classes:
//import dev.abakulin.mbapi.ApiClient;
//import dev.abakulin.mbapi.ApiException;
//import dev.abakulin.mbapi.Configuration;
//import dev.abakulin.mbapi.auth.*;
//import dev.abakulin.mbapi.api.VehiclesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");

VehiclesApi apiInstance = new VehiclesApi();
try {
    Vehicles result = apiInstance.getAllVehicles();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#getAllVehicles");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Vehicles**](Vehicles.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVehicleById"></a>
# **getVehicleById**
> VehicleDetail getVehicleById(vehicleId)

Get vehicle by ID.

Returns detailed information about the vehicle like its licensplate, sales designation or its FIN or VIN.

### Example
```java
// Import classes:
//import dev.abakulin.mbapi.ApiClient;
//import dev.abakulin.mbapi.ApiException;
//import dev.abakulin.mbapi.Configuration;
//import dev.abakulin.mbapi.auth.*;
//import dev.abakulin.mbapi.api.VehiclesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");

VehiclesApi apiInstance = new VehiclesApi();
String vehicleId = "vehicleId_example"; // String | ID of vehicle to return.
try {
    VehicleDetail result = apiInstance.getVehicleById(vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#getVehicleById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vehicleId** | **String**| ID of vehicle to return. |

### Return type

[**VehicleDetail**](VehicleDetail.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

