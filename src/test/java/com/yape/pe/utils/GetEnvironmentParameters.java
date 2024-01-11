package com.yape.pe.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.environment.WebDriverConfiguredEnvironment;
import net.thucydides.core.util.EnvironmentVariables;

public class GetEnvironmentParameters {

  private static final EnvironmentVariables environmentVariables = WebDriverConfiguredEnvironment.getEnvironmentVariables();

  public static String getUrl() {
    return EnvironmentSpecificConfiguration.from(environmentVariables)
        .getProperty("base.uri");
  }

}
