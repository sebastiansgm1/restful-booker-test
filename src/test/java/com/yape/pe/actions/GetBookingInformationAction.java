package com.yape.pe.actions;

import static com.yape.pe.utils.GetEnvironmentParameters.getUrl;
import static com.yape.pe.utils.ServicesPaths.BOOKING;

import com.yape.pe.models.booking.Booking;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetBookingInformationAction {

  @Step("Get Booking information")
  public Booking getInformation(int id) {
    return SerenityRest.given().log().all().baseUri(getUrl()).when()
        .get(BOOKING.getPath() + "/" + id).then().log().all().statusCode(200).extract().body()
        .as(Booking.class);
  }

  @Step
  public String consultNonExistentReservation(int id) {
    return SerenityRest.given().log().all().baseUri(getUrl()).when()
        .get(BOOKING.getPath() + "/" + id).then().log().all().statusCode(404).extract().body()
        .asString();
  }
}
