# OdometerApi

All URIs are relative to *https://api.mercedes-benz.com/experimental/connectedvehicle/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getOdometerStatus**](OdometerApi.md#getOdometerStatus) | **GET** /vehicles/{vehicleId}/odometer | Provides information about the odometer.


<a name="getOdometerStatus"></a>
# **getOdometerStatus**
> DistanceDrivenResponse getOdometerStatus(vehicleId)

Provides information about the odometer.

Provides information about the odometer like milage aka odometer, distance driven since reset, distance driven since the enige start.

### Example
```java
// Import classes:
//import dev.abakulin.mbapi.ApiClient;
//import dev.abakulin.mbapi.ApiException;
//import dev.abakulin.mbapi.Configuration;
//import dev.abakulin.mbapi.auth.*;
//import dev.abakulin.mbapi.api.OdometerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");

OdometerApi apiInstance = new OdometerApi();
String vehicleId = "vehicleId_example"; // String | ID of vehicle to return.
try {
    DistanceDrivenResponse result = apiInstance.getOdometerStatus(vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OdometerApi#getOdometerStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vehicleId** | **String**| ID of vehicle to return. |

### Return type

[**DistanceDrivenResponse**](DistanceDrivenResponse.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

