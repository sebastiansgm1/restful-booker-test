package com.yape.pe.actions;

import static com.yape.pe.utils.GetEnvironmentParameters.getUrl;
import static com.yape.pe.utils.ServicesPaths.BOOKING;

import com.yape.pe.models.booking.Booking;
import io.restassured.http.ContentType;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;

public class UpdateBookingAction {

  @Step("Update booking operation")
  public Booking updateBooking(Booking booking, String token, int bookingId) {
    return SerenityRest.given().log().all().baseUri(getUrl()).contentType(ContentType.JSON)
        .header("Cookie", "token=" + token).body(booking).when()
        .put(BOOKING.getPath() + "/" + bookingId)
        .then().log().all().statusCode(200).extract().body().as(Booking.class);
  }

  @Step("Partially update a reservation")
  public Booking partiallyUpdate(Map<String, Object> booking, String token, int bookingId) {
    return SerenityRest.given().log().all().baseUri(getUrl()).contentType(ContentType.JSON)
        .header("Cookie", "token=" + token).body(booking).when()
        .patch(BOOKING.getPath() + "/" + bookingId)
        .then().log().all().statusCode(200).extract().body().as(Booking.class);
  }

  /**
   * Muestra de implementación de softassertions para realizar mas de una aserción
   */
  @Step("Compare booking information")
  public void compareBookingInformation(Booking newBookingInformation,
      Booking updatedBookingInformation) {
    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(
        newBookingInformation.getFirstname().compareTo(updatedBookingInformation.getFirstname()));
    softly.assertThat(
        newBookingInformation.getLastname().compareTo(updatedBookingInformation.getLastname()));
    softly.assertThat(
        newBookingInformation.getTotalprice().compareTo(updatedBookingInformation.getTotalprice()));
    softly.assertThat(newBookingInformation.getDepositpaid()
        .compareTo(updatedBookingInformation.getDepositpaid()));
    softly.assertThat(newBookingInformation.getAdditionalneeds()
        .compareTo(updatedBookingInformation.getAdditionalneeds()));
    softly.assertThat(newBookingInformation.getBookingdates().getCheckin()
        .compareTo(newBookingInformation.getBookingdates().getCheckin()));
    softly.assertThat(newBookingInformation.getBookingdates().getCheckout()
        .compareTo(newBookingInformation.getBookingdates().getCheckout()));
    softly.assertAll();
  }
}
