Mercedes-Benz developers API
----------------------------

File `swagger_experimental_connected_vehicle_api_3.json` contains Swagger API description.

Please use file `swagger_experimental_connected_vehicle_api_3_1.json` to have OAuth2 authentication mechanism.

To generate source code from document use [swagger-code-generator](https://github.com/swagger-api/swagger-codegen).

To run in Java (from project root):

```
java -jar ../swagger-codegen/modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate \
    -i docs/api/swagger_experimental_connected_vehicle_api_3.json \
    -l java \
    -o mbapi \
    -c docs/api/java-genconfig.json
```

To run in Kotlin (from project root):

```
java -jar ../swagger-codegen/modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate \
    -i docs/api/swagger_experimental_connected_vehicle_api_3_1.json \
    -l kotlin \
    -o mbapi-kotlin \
    -c docs/api/kotlin-genconfig.json
```