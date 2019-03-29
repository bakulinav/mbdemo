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


package dev.abakulin.mbapi.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Vehicle
 */

public class Vehicle {
  @SerializedName("id")
  private String id = null;

  @SerializedName("licenseplate")
  private String licenseplate = null;

  @SerializedName("finorvin")
  private String finorvin = null;

  public Vehicle id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "77-9BO-_vTsH1LoEdu-_vZwpb_Oz4FO0Frkfskuw3uuKCFSSbeQ7Og3sOr3L815f", value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Vehicle licenseplate(String licenseplate) {
    this.licenseplate = licenseplate;
    return this;
  }

   /**
   * The license plate of the vehicle.
   * @return licenseplate
  **/
  @ApiModelProperty(example = "S-GG-116", value = "The license plate of the vehicle.")
  public String getLicenseplate() {
    return licenseplate;
  }

  public void setLicenseplate(String licenseplate) {
    this.licenseplate = licenseplate;
  }

  public Vehicle finorvin(String finorvin) {
    this.finorvin = finorvin;
    return this;
  }

   /**
   * The FIN or VIN of the vehicle.
   * @return finorvin
  **/
  @ApiModelProperty(example = "WDD***********002", value = "The FIN or VIN of the vehicle.")
  public String getFinorvin() {
    return finorvin;
  }

  public void setFinorvin(String finorvin) {
    this.finorvin = finorvin;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(this.id, vehicle.id) &&
        Objects.equals(this.licenseplate, vehicle.licenseplate) &&
        Objects.equals(this.finorvin, vehicle.finorvin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, licenseplate, finorvin);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vehicle {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    licenseplate: ").append(toIndentedString(licenseplate)).append("\n");
    sb.append("    finorvin: ").append(toIndentedString(finorvin)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

