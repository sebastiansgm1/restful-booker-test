package com.yape.pe.utils;

public enum ServicesPaths {
  AUTH_PATH("/auth"),
  PING("/ping"),
  BOOKING("/booking");

  private String path;

  ServicesPaths(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }
}
