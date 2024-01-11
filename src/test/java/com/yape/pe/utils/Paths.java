package com.yape.pe.utils;

public enum Paths {
  JSON_SCHEMA_BOOKING_CREATION("./data/schemas/booking_creation_schema.json"),
  JSON_SCHEMA_BOOKING("./data/schemas/booking_schema.json");

  private String path;

  Paths(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }
}
