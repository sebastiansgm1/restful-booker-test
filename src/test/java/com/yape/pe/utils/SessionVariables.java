package com.yape.pe.utils;

public enum SessionVariables {
  SESSION_ID("Session id"),
  SESSION_TOKEN("Session token");

  private String variable;

  SessionVariables(String variable) {
    this.variable = variable;
  }

  public String getVariable() {
    return variable;
  }
}
