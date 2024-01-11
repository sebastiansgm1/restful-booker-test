package com.yape.pe.actions;

import static com.yape.pe.utils.GetEnvironmentParameters.getUrl;
import static com.yape.pe.utils.ServicesPaths.AUTH_PATH;

import com.yape.pe.models.user.User;
import com.yape.pe.models.user.UserBuilder;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AuthRestfulBookerApplicationAction {

  @Step("Request on auth API client")
  public String authApiRequest(String userName, String password) {
    User user = UserBuilder.anUser().withUsername(userName).withPassword(password).build();
    return SerenityRest.given().baseUri(getUrl()).contentType(ContentType.JSON).body(user).log()
        .all()
        .when().post(AUTH_PATH.getPath()).then().log().all().statusCode(200).extract()
        .path("token");
  }
}
