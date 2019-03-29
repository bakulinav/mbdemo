# OdometerApi

All URIs are relative to *https://api.mercedes-benz.com/experimental/connectedvehicle_tryout/v1*

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
//import dev.abakulin.mbapi.ApiException;
//import dev.abakulin.mbapi.api.OdometerApi;


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

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

