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

import dev.abakulin.mbapi.ApiCallback;
import dev.abakulin.mbapi.ApiClient;
import dev.abakulin.mbapi.ApiException;
import dev.abakulin.mbapi.ApiResponse;
import dev.abakulin.mbapi.Configuration;
import dev.abakulin.mbapi.Pair;
import dev.abakulin.mbapi.ProgressRequestBody;
import dev.abakulin.mbapi.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import dev.abakulin.mbapi.model.ErrorResponse;
import dev.abakulin.mbapi.model.VehicleDetail;
import dev.abakulin.mbapi.model.Vehicles;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehiclesApi {
    private ApiClient apiClient;

    public VehiclesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public VehiclesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getAllVehicles
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getAllVehiclesCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/vehicles";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAllVehiclesValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getAllVehiclesCall(progressListener, progressRequestListener);
        return call;

    }

    /**
     * Find all vehicles.
     * List all of the user&#39;s vehicles.
     * @return Vehicles
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Vehicles getAllVehicles() throws ApiException {
        ApiResponse<Vehicles> resp = getAllVehiclesWithHttpInfo();
        return resp.getData();
    }

    /**
     * Find all vehicles.
     * List all of the user&#39;s vehicles.
     * @return ApiResponse&lt;Vehicles&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Vehicles> getAllVehiclesWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getAllVehiclesValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<Vehicles>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Find all vehicles. (asynchronously)
     * List all of the user&#39;s vehicles.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAllVehiclesAsync(final ApiCallback<Vehicles> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAllVehiclesValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Vehicles>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getVehicleById
     * @param vehicleId ID of vehicle to return. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getVehicleByIdCall(String vehicleId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/vehicles/{vehicleId}"
            .replaceAll("\\{" + "vehicleId" + "\\}", apiClient.escapeString(vehicleId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getVehicleByIdValidateBeforeCall(String vehicleId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'vehicleId' is set
        if (vehicleId == null) {
            throw new ApiException("Missing the required parameter 'vehicleId' when calling getVehicleById(Async)");
        }
        

        com.squareup.okhttp.Call call = getVehicleByIdCall(vehicleId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get vehicle by ID.
     * Returns detailed information about the vehicle like its licensplate, sales designation or its FIN or VIN.
     * @param vehicleId ID of vehicle to return. (required)
     * @return VehicleDetail
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public VehicleDetail getVehicleById(String vehicleId) throws ApiException {
        ApiResponse<VehicleDetail> resp = getVehicleByIdWithHttpInfo(vehicleId);
        return resp.getData();
    }

    /**
     * Get vehicle by ID.
     * Returns detailed information about the vehicle like its licensplate, sales designation or its FIN or VIN.
     * @param vehicleId ID of vehicle to return. (required)
     * @return ApiResponse&lt;VehicleDetail&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<VehicleDetail> getVehicleByIdWithHttpInfo(String vehicleId) throws ApiException {
        com.squareup.okhttp.Call call = getVehicleByIdValidateBeforeCall(vehicleId, null, null);
        Type localVarReturnType = new TypeToken<VehicleDetail>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get vehicle by ID. (asynchronously)
     * Returns detailed information about the vehicle like its licensplate, sales designation or its FIN or VIN.
     * @param vehicleId ID of vehicle to return. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getVehicleByIdAsync(String vehicleId, final ApiCallback<VehicleDetail> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getVehicleByIdValidateBeforeCall(vehicleId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<VehicleDetail>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}