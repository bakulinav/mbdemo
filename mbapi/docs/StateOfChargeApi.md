# StateOfChargeApi

All URIs are relative to *https://api.mercedes-benz.com/experimental/connectedvehicle/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStateOfCharge**](StateOfChargeApi.md#getStateOfCharge) | **GET** /vehicles/{vehicleId}/stateofcharge | Provides the current status of the battery pack.


<a name="getStateOfCharge"></a>
# **getStateOfCharge**
> StateOfCharge getStateOfCharge(vehicleId)

Provides the current status of the battery pack.

Provides the current status of the battery pack.

### Example
```java
// Import classes:
//import dev.abakulin.mbapi.ApiClient;
//import dev.abakulin.mbapi.ApiException;
//import dev.abakulin.mbapi.Configuration;
//import dev.abakulin.mbapi.auth.*;
//import dev.abakulin.mbapi.api.StateOfChargeApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure OAuth2 access token for authorization: oauth2
OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
oauth2.setAccessToken("YOUR ACCESS TOKEN");

StateOfChargeApi apiInstance = new StateOfChargeApi();
String vehicleId = "vehicleId_example"; // String | ID of vehicle to return.
try {
    StateOfCharge result = apiInstance.getStateOfCharge(vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StateOfChargeApi#getStateOfCharge");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vehicleId** | **String**| ID of vehicle to return. |

### Return type

[**StateOfCharge**](StateOfCharge.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

