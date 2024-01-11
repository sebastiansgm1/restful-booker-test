package com.yape.pe.actions;

import static com.yape.pe.utils.GetEnvironmentParameters.getUrl;
import static com.yape.pe.utils.ServicesPaths.PING;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class HealthCheckAction {

  @Step("check API health")
  public String verifyApplicationStatus() {
    return SerenityRest.given().log().all().baseUri(getUrl()).when().get(PING.getPath()).then()
        .log().all().statusCode(201).extract().body().asString();
  }
}
