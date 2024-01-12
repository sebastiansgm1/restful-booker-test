package com.yape.pe.actions;

import static com.yape.pe.utils.GetEnvironmentParameters.getUrl;
import static com.yape.pe.utils.ServicesPaths.BOOKING;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DeleteBookingAction {

  @Step("Delete booking")
  public void deleteById(int id, String token) {
    SerenityRest.given().log().all().baseUri(getUrl()).header("Cookie", "token=" + token).when()
        .delete(BOOKING.getPath() + "/" + id).then().log().all().statusCode(201);
  }
}
