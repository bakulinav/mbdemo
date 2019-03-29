# FuelApi

All URIs are relative to *https://api.mercedes-benz.com/experimental/connectedvehicle/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getFuelLevel**](FuelApi.md#getFuelLevel) | **GET** /vehicles/{vehicleId}/fuel | Returns the current fuel level.


<a name="getFuelLevel"></a>
# **getFuelLevel**
> FuelLevel getFuelLevel(vehicleId)

Returns the current fuel level.

Provides information about the current fuel level.

### Example
```java
// Import classes:
//import dev.abakulin.mbapi.ApiClient;
//import dev.abakulin.mbapi.ApiException;
//import dev.abakulin.mbapi.Configuration;
//import dev.abakulin.mbapi.auth.*;
//import dev.abakulin.mbapi.api.FuelApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");

FuelApi apiInstance = new FuelApi();
String vehicleId = "vehicleId_example"; // String | ID of vehicle to return.
try {
    FuelLevel result = apiInstance.getFuelLevel(vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FuelApi#getFuelLevel");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vehicleId** | **String**| ID of vehicle to return. |

### Return type

[**FuelLevel**](FuelLevel.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

