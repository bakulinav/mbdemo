# TiresApi

All URIs are relative to *https://api.mercedes-benz.com/experimental/connectedvehicle_tryout/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTiresStatus**](TiresApi.md#getTiresStatus) | **GET** /vehicles/{vehicleId}/tires | 


<a name="getTiresStatus"></a>
# **getTiresStatus**
> Tires getTiresStatus(vehicleId)



Get pressure of all tires of the vehicle.

### Example
```java
// Import classes:
//import dev.abakulin.mbapi.ApiException;
//import dev.abakulin.mbapi.api.TiresApi;


TiresApi apiInstance = new TiresApi();
String vehicleId = "vehicleId_example"; // String | ID of vehicle to return.
try {
    Tires result = apiInstance.getTiresStatus(vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TiresApi#getTiresStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vehicleId** | **String**| ID of vehicle to return. |

### Return type

[**Tires**](Tires.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

