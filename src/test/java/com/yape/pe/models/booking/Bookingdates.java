
package com.yape.pe.models.booking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bookingdates {

  @JsonProperty("checkin")
  private String checkin;
  @JsonProperty("checkout")
  private String checkout;

  @JsonProperty("checkin")
  public String getCheckin() {
    return checkin;
  }

  @JsonProperty("checkin")
  public void setCheckin(String checkin) {
    this.checkin = checkin;
  }

  @JsonProperty("checkout")
  public String getCheckout() {
    return checkout;
  }

  @JsonProperty("checkout")
  public void setCheckout(String checkout) {
    this.checkout = checkout;
  }

}
