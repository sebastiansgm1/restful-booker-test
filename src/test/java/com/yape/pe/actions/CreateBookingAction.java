package com.yape.pe.actions;

import static com.yape.pe.models.booking.Booking.getBooking;
import static com.yape.pe.utils.GetEnvironmentParameters.getUrl;
import static com.yape.pe.utils.ServicesPaths.BOOKING;

import com.yape.pe.models.booking.Booking;
import io.restassured.http.ContentType;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CreateBookingAction {

  @Step
  public int createNewBooking(Map<String, String> bookingData) {
    Booking booking = getBooking(bookingData);
    SerenityRest.given().log().all().baseUri(getUrl()).contentType(ContentType.JSON)
        .body(booking).when().post(BOOKING.getPath()).then().log().all().statusCode(200);
    return SerenityRest.lastResponse().path("bookingid"); //Esta es otra forma de recuperar un valor de la respuesta de un servicio
  }
}
