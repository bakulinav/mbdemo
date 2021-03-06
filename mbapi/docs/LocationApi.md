# LocationApi

All URIs are relative to *https://api.mercedes-benz.com/experimental/connectedvehicle/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getLocation**](LocationApi.md#getLocation) | **GET** /vehicles/{vehicleId}/location | Retrieves the current location of the vehicle.


<a name="getLocation"></a>
# **getLocation**
> Location getLocation(vehicleId)

Retrieves the current location of the vehicle.

Returns the current location and the heading of the vehicle.

### Example
```java
// Import classes:
//import dev.abakulin.mbapi.ApiClient;
//import dev.abakulin.mbapi.ApiException;
//import dev.abakulin.mbapi.Configuration;
//import dev.abakulin.mbapi.auth.*;
//import dev.abakulin.mbapi.api.LocationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");

LocationApi apiInstance = new LocationApi();
String vehicleId = "vehicleId_example"; // String | ID of vehicle to return.
try {
    Location result = apiInstance.getLocation(vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LocationApi#getLocation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vehicleId** | **String**| ID of vehicle to return. |

### Return type

[**Location**](Location.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

