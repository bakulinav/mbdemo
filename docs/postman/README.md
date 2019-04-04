Postman Mercedes-Benz developers API collection
-----------------------------------------------

File [Experimental Connected Vehicle API.postman_collection.json](Experimental&#32;Connected&#32;Vehicle&#32;API.postman_collection.json)
contains Postman collection for Mercedes-Benz developers API.
Made from Swagger file [swagger_experimental_connected_vehicle_api_3_1.json](../api/swagger_experimental_connected_vehicle_api_3_1.json)
Collection can be imported to [Postman](https://www.getpostman.com) application.

For using the Collection you need environment variables. You can find them if import [Mercedes-Benz.postman_environment.json](Mercedes-Benz.postman_environment.json)
(for production API) or [Mercedes-Benz-Tryout.postman_environment.json](Mercedes-Benz-Tryout.postman_environment.json) (for demo API)
variable files.

All requests are secured so you need authorization. Use collection authorization for do not setup it for every request.
Use OAuth2 method for Production API with your `clientId` and `clientSecret` variables and Demo (Tryout) API with Bearer type and with `tryoutAccessToken` variable.
