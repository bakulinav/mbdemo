Mercedes-Benz developers API
----------------------------

File `swagger_experimental_connected_vehicle_api_3.json` contains Swagger API description.

To generate source code from document use [swagger-code-generator](https://github.com/swagger-api/swagger-codegen).

To run in Java (from project root):

```
java -jar ../swagger-codegen/modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate \
    -i docs/api/swagger_experimental_connected_vehicle_api_3.json \
    -l java \
    -o mbapi \
    -c docs/api/java-genconfig.json
```
