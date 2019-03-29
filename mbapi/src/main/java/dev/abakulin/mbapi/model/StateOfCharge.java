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
import java.math.BigDecimal;

/**
 * StateOfCharge
 */

public class StateOfCharge {
  /**
   * Gets or Sets unit
   */
  @JsonAdapter(UnitEnum.Adapter.class)
  public enum UnitEnum {
    PERCENT("PERCENT");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UnitEnum fromValue(String text) {
      for (UnitEnum b : UnitEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<UnitEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UnitEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UnitEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return UnitEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("unit")
  private UnitEnum unit = null;

  @SerializedName("value")
  private Integer value = null;

  /**
   * Gets or Sets retrievalstatus
   */
  @JsonAdapter(RetrievalstatusEnum.Adapter.class)
  public enum RetrievalstatusEnum {
    VALID("VALID"),
    
    INITIALIZED("INITIALIZED"),
    
    INVALID("INVALID"),
    
    NOT_SUPPORTED("NOT_SUPPORTED");

    private String value;

    RetrievalstatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RetrievalstatusEnum fromValue(String text) {
      for (RetrievalstatusEnum b : RetrievalstatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<RetrievalstatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RetrievalstatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RetrievalstatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return RetrievalstatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("retrievalstatus")
  private RetrievalstatusEnum retrievalstatus = null;

  @SerializedName("timestamp")
  private BigDecimal timestamp = null;

  public StateOfCharge unit(UnitEnum unit) {
    this.unit = unit;
    return this;
  }

   /**
   * Get unit
   * @return unit
  **/
  @ApiModelProperty(example = "PERCENT", value = "")
  public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }

  public StateOfCharge value(Integer value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(example = "0", value = "")
  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public StateOfCharge retrievalstatus(RetrievalstatusEnum retrievalstatus) {
    this.retrievalstatus = retrievalstatus;
    return this;
  }

   /**
   * Get retrievalstatus
   * @return retrievalstatus
  **/
  @ApiModelProperty(example = "VALID", value = "")
  public RetrievalstatusEnum getRetrievalstatus() {
    return retrievalstatus;
  }

  public void setRetrievalstatus(RetrievalstatusEnum retrievalstatus) {
    this.retrievalstatus = retrievalstatus;
  }

  public StateOfCharge timestamp(BigDecimal timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(example = "1.23456789E8", value = "")
  public BigDecimal getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(BigDecimal timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StateOfCharge stateOfCharge = (StateOfCharge) o;
    return Objects.equals(this.unit, stateOfCharge.unit) &&
        Objects.equals(this.value, stateOfCharge.value) &&
        Objects.equals(this.retrievalstatus, stateOfCharge.retrievalstatus) &&
        Objects.equals(this.timestamp, stateOfCharge.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unit, value, retrievalstatus, timestamp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StateOfCharge {\n");
    
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    retrievalstatus: ").append(toIndentedString(retrievalstatus)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

