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
 * JSON object containing the command to lock or unlock the doors
 */
@ApiModel(description = "JSON object containing the command to lock or unlock the doors")

public class DoorLockChangeRequestBody {
  /**
   * Command to lock or unlock the doors
   */
  @JsonAdapter(CommandEnum.Adapter.class)
  public enum CommandEnum {
    LOCK("LOCK"),
    
    UNLOCK("UNLOCK");

    private String value;

    CommandEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CommandEnum fromValue(String text) {
      for (CommandEnum b : CommandEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<CommandEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CommandEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CommandEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return CommandEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("command")
  private CommandEnum command = null;

  public DoorLockChangeRequestBody command(CommandEnum command) {
    this.command = command;
    return this;
  }

   /**
   * Command to lock or unlock the doors
   * @return command
  **/
  @ApiModelProperty(example = "LOCK", required = true, value = "Command to lock or unlock the doors")
  public CommandEnum getCommand() {
    return command;
  }

  public void setCommand(CommandEnum command) {
    this.command = command;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DoorLockChangeRequestBody doorLockChangeRequestBody = (DoorLockChangeRequestBody) o;
    return Objects.equals(this.command, doorLockChangeRequestBody.command);
  }

  @Override
  public int hashCode() {
    return Objects.hash(command);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DoorLockChangeRequestBody {\n");
    
    sb.append("    command: ").append(toIndentedString(command)).append("\n");
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

