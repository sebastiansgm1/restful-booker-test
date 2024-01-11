package com.yape.pe.actions;

import static com.yape.pe.utils.GetEnvironmentParameters.getUrl;
import static com.yape.pe.utils.ServicesPaths.BOOKING;

import java.util.List;
import java.util.Map;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetBookingListIdsActions {

  @Step("View the list of identifiers")
  public List<Map<String, Integer>> getBookingIds() {
    return SerenityRest.given().log().all().baseUri(getUrl()).when().get(BOOKING.getPath()).then()
        .log().all()
        .statusCode(200).extract().as(List.class);
  }

}
