# DoorsApi

All URIs are relative to *https://api.mercedes-benz.com/experimental/connectedvehicle_tryout/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getDoorsStatus**](DoorsApi.md#getDoorsStatus) | **GET** /vehicles/{vehicleId}/doors | Get the status of all doors of the vehicle.
[**postDoors**](DoorsApi.md#postDoors) | **POST** /vehicles/{vehicleId}/doors | Locks or unlocks all doors of the vehicle.


<a name="getDoorsStatus"></a>
# **getDoorsStatus**
> Doors getDoorsStatus(vehicleId)

Get the status of all doors of the vehicle.

Returns status of all doors of the vehicle. It informs about each door if it is locked, unlocked, open or closed.

### Example
```java
// Import classes:
//import dev.abakulin.mbapi.ApiException;
//import dev.abakulin.mbapi.api.DoorsApi;


DoorsApi apiInstance = new DoorsApi();
String vehicleId = "vehicleId_example"; // String | ID of vehicle to return.
try {
    Doors result = apiInstance.getDoorsStatus(vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DoorsApi#getDoorsStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vehicleId** | **String**| ID of vehicle to return. |

### Return type

[**Doors**](Doors.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postDoors"></a>
# **postDoors**
> DoorLockChangedStatus postDoors(vehicleId, body)

Locks or unlocks all doors of the vehicle.

Locks or unlocks all doors of the vehicle.

### Example
```java
// Import classes:
//import dev.abakulin.mbapi.ApiException;
//import dev.abakulin.mbapi.api.DoorsApi;


DoorsApi apiInstance = new DoorsApi();
String vehicleId = "vehicleId_example"; // String | ID of vehicle to return.
DoorLockChangeRequestBody body = new DoorLockChangeRequestBody(); // DoorLockChangeRequestBody | JSON object containing the command to lock or unlock the doors.
try {
    DoorLockChangedStatus result = apiInstance.postDoors(vehicleId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DoorsApi#postDoors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **vehicleId** | **String**| ID of vehicle to return. |
 **body** | [**DoorLockChangeRequestBody**](DoorLockChangeRequestBody.md)| JSON object containing the command to lock or unlock the doors. |

### Return type

[**DoorLockChangedStatus**](DoorLockChangedStatus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

