/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.kaaproject.kaa.server.common.thrift.gen.operations;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

/**
 * This is enum of changes type. The same as org.kaaproject.kaa.common.dto.ChangeType
 * 
 */
public enum Operation implements org.apache.thrift.TEnum {
  UPDATE(1),
  DELETE(2),
  INSERT(3),
  ADD_TOPIC(4),
  REMOVE_TOPIC(5),
  UPDATE_WEIGHT(6),
  ADD_CONF(7),
  REMOVE_CONF(8),
  ADD_PROF(9),
  REMOVE_PROF(10),
  REMOVE_GROUP(11),
  REMOVE_CONF_VERSION(12),
  REMOVE_PROF_VERSION(13),
  REMOVE_NOTIFICATION_VERSION(14),
  ADD_LOG_APPENDER(15),
  REMOVE_LOG_APPENDER(16),
  UPDATE_LOG_APPENDER(17),
  ADD_USER_VERIFIER(18),
  REMOVE_USER_VERIFIER(19),
  UPDATE_USER_VERIFIER(20);

  private final int value;

  private Operation(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static Operation findByValue(int value) { 
    switch (value) {
      case 1:
        return UPDATE;
      case 2:
        return DELETE;
      case 3:
        return INSERT;
      case 4:
        return ADD_TOPIC;
      case 5:
        return REMOVE_TOPIC;
      case 6:
        return UPDATE_WEIGHT;
      case 7:
        return ADD_CONF;
      case 8:
        return REMOVE_CONF;
      case 9:
        return ADD_PROF;
      case 10:
        return REMOVE_PROF;
      case 11:
        return REMOVE_GROUP;
      case 12:
        return REMOVE_CONF_VERSION;
      case 13:
        return REMOVE_PROF_VERSION;
      case 14:
        return REMOVE_NOTIFICATION_VERSION;
      case 15:
        return ADD_LOG_APPENDER;
      case 16:
        return REMOVE_LOG_APPENDER;
      case 17:
        return UPDATE_LOG_APPENDER;
      case 18:
        return ADD_USER_VERIFIER;
      case 19:
        return REMOVE_USER_VERIFIER;
      case 20:
        return UPDATE_USER_VERIFIER;
      default:
        return null;
    }
  }
}
