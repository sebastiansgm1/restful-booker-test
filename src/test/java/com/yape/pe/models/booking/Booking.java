
package com.yape.pe.models.booking;

import static com.yape.pe.models.booking.BookingBuilder.aBooking;
import static com.yape.pe.models.booking.BookingdatesBuilder.aBookingdates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking {

  @JsonProperty("firstname")
  private String firstname;
  @JsonProperty("lastname")
  private String lastname;
  @JsonProperty("totalprice")
  private Integer totalprice;
  @JsonProperty("depositpaid")
  private Boolean depositpaid;
  @JsonProperty("bookingdates")
  private Bookingdates bookingdates;
  @JsonProperty("additionalneeds")
  private String additionalneeds;

  @JsonProperty("firstname")
  public String getFirstname() {
    return firstname;
  }

  @JsonProperty("firstname")
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  @JsonProperty("lastname")
  public String getLastname() {
    return lastname;
  }

  @JsonProperty("lastname")
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  @JsonProperty("totalprice")
  public Integer getTotalprice() {
    return totalprice;
  }

  @JsonProperty("totalprice")
  public void setTotalprice(Integer totalprice) {
    this.totalprice = totalprice;
  }

  @JsonProperty("depositpaid")
  public Boolean getDepositpaid() {
    return depositpaid;
  }

  @JsonProperty("depositpaid")
  public void setDepositpaid(Boolean depositpaid) {
    this.depositpaid = depositpaid;
  }

  @JsonProperty("bookingdates")
  public Bookingdates getBookingdates() {
    return bookingdates;
  }

  @JsonProperty("bookingdates")
  public void setBookingdates(Bookingdates bookingdates) {
    this.bookingdates = bookingdates;
  }

  @JsonProperty("additionalneeds")
  public String getAdditionalneeds() {
    return additionalneeds;
  }

  @JsonProperty("additionalneeds")
  public void setAdditionalneeds(String additionalneeds) {
    this.additionalneeds = additionalneeds;
  }

  public static Booking getBooking(Map<String, String> bookingData) {
    Bookingdates bookingdates = aBookingdates().withCheckin(bookingData.get("checkin"))
        .withCheckout(bookingData.get("checkout")).build();
    return aBooking().withFirstname(bookingData.get("firstname"))
        .withLastname(bookingData.get("lastname"))
        .withTotalprice(Integer.parseInt(bookingData.get("totalprice")))
        .withDepositpaid(Boolean.parseBoolean(bookingData.get("depositpaid")))
        .withBookingdates(bookingdates).withAdditionalneeds(bookingData.get("additionalneeds")).build();
  }
}
