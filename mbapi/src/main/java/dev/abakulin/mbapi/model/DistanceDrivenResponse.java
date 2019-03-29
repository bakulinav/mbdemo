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
import dev.abakulin.mbapi.model.DistanceDriven;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * DistanceDrivenResponse
 */

public class DistanceDrivenResponse {
  @SerializedName("odometer")
  private DistanceDriven odometer = null;

  @SerializedName("distancesincereset")
  private DistanceDriven distancesincereset = null;

  @SerializedName("distancesincestart")
  private DistanceDriven distancesincestart = null;

  public DistanceDrivenResponse odometer(DistanceDriven odometer) {
    this.odometer = odometer;
    return this;
  }

   /**
   * Get odometer
   * @return odometer
  **/
  @ApiModelProperty(value = "")
  public DistanceDriven getOdometer() {
    return odometer;
  }

  public void setOdometer(DistanceDriven odometer) {
    this.odometer = odometer;
  }

  public DistanceDrivenResponse distancesincereset(DistanceDriven distancesincereset) {
    this.distancesincereset = distancesincereset;
    return this;
  }

   /**
   * Get distancesincereset
   * @return distancesincereset
  **/
  @ApiModelProperty(value = "")
  public DistanceDriven getDistancesincereset() {
    return distancesincereset;
  }

  public void setDistancesincereset(DistanceDriven distancesincereset) {
    this.distancesincereset = distancesincereset;
  }

  public DistanceDrivenResponse distancesincestart(DistanceDriven distancesincestart) {
    this.distancesincestart = distancesincestart;
    return this;
  }

   /**
   * Get distancesincestart
   * @return distancesincestart
  **/
  @ApiModelProperty(value = "")
  public DistanceDriven getDistancesincestart() {
    return distancesincestart;
  }

  public void setDistancesincestart(DistanceDriven distancesincestart) {
    this.distancesincestart = distancesincestart;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DistanceDrivenResponse distanceDrivenResponse = (DistanceDrivenResponse) o;
    return Objects.equals(this.odometer, distanceDrivenResponse.odometer) &&
        Objects.equals(this.distancesincereset, distanceDrivenResponse.distancesincereset) &&
        Objects.equals(this.distancesincestart, distanceDrivenResponse.distancesincestart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(odometer, distancesincereset, distancesincestart);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DistanceDrivenResponse {\n");
    
    sb.append("    odometer: ").append(toIndentedString(odometer)).append("\n");
    sb.append("    distancesincereset: ").append(toIndentedString(distancesincereset)).append("\n");
    sb.append("    distancesincestart: ").append(toIndentedString(distancesincestart)).append("\n");
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
