package com.yape.pe.actions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

public class JsonSchemaValidationAction {

  @Step("Schema json validation")
  public void validateJsonSchema(String jsonSchemaPath) {
    JSONObject response = new JSONObject(SerenityRest.lastResponse().body().path(""));
    assertThat(response.toJSONString(),
        matchesJsonSchemaInClasspath(jsonSchemaPath));
  }

}
