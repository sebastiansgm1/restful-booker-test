package com.yape.pe.utils;

public enum Users {
  ADMIN_USER("admin", "password123");

  private String userName;
  private String password;

  Users(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }
}
