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
import dev.abakulin.mbapi.model.Tires;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TiresApi {
    private ApiClient apiClient;

    public TiresApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TiresApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getTiresStatus
     * @param vehicleId ID of vehicle to return. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getTiresStatusCall(String vehicleId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/vehicles/{vehicleId}/tires"
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

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTiresStatusValidateBeforeCall(String vehicleId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'vehicleId' is set
        if (vehicleId == null) {
            throw new ApiException("Missing the required parameter 'vehicleId' when calling getTiresStatus(Async)");
        }
        

        com.squareup.okhttp.Call call = getTiresStatusCall(vehicleId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * 
     * Get pressure of all tires of the vehicle.
     * @param vehicleId ID of vehicle to return. (required)
     * @return Tires
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Tires getTiresStatus(String vehicleId) throws ApiException {
        ApiResponse<Tires> resp = getTiresStatusWithHttpInfo(vehicleId);
        return resp.getData();
    }

    /**
     * 
     * Get pressure of all tires of the vehicle.
     * @param vehicleId ID of vehicle to return. (required)
     * @return ApiResponse&lt;Tires&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Tires> getTiresStatusWithHttpInfo(String vehicleId) throws ApiException {
        com.squareup.okhttp.Call call = getTiresStatusValidateBeforeCall(vehicleId, null, null);
        Type localVarReturnType = new TypeToken<Tires>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Get pressure of all tires of the vehicle.
     * @param vehicleId ID of vehicle to return. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTiresStatusAsync(String vehicleId, final ApiCallback<Tires> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getTiresStatusValidateBeforeCall(vehicleId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Tires>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
