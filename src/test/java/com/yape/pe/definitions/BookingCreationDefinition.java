package com.yape.pe.definitions;

import static com.yape.pe.utils.Paths.JSON_SCHEMA_BOOKING;
import static com.yape.pe.utils.Paths.JSON_SCHEMA_BOOKING_CREATION;
import static com.yape.pe.utils.SessionVariables.SESSION_ID;
import static org.assertj.core.api.Assertions.assertThat;

import com.yape.pe.actions.CreateBookingAction;
import com.yape.pe.actions.GetBookingInformationAction;
import com.yape.pe.actions.GetBookingListIdsActions;
import com.yape.pe.actions.HealthCheckAction;
import com.yape.pe.actions.JsonSchemaValidationAction;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class BookingCreationDefinition {

  @Steps
  HealthCheckAction healthCheckAction;
  @Steps
  CreateBookingAction createBookingAction;
  @Steps
  JsonSchemaValidationAction jsonSchemaValidationAction;
  @Steps
  GetBookingInformationAction getBookingInformationAction;
  @Steps
  GetBookingListIdsActions getBookingListIdsActions;

  private List<Integer> bookinhIds = new ArrayList<>();

  @Dado("I check the status of the booking service")
  public void verifyHealthService() {
    healthCheckAction.verifyApplicationStatus();
  }

  @Cuando("I make a reservation with the following information")
  public void createBooking(List<Map<String, String>> cashOutData) {
    for (Map<String, String> data : cashOutData) {
      int id = createBookingAction.createNewBooking(data);
      Serenity.setSessionVariable(SESSION_ID.getVariable())
          .to(id); //Esta instrucción guarda el id de la reservación en una variable de sesión para ser usado en otra clase
      jsonSchemaValidationAction.validateJsonSchema(JSON_SCHEMA_BOOKING_CREATION.getPath());
      Serenity.reportThat("The id must be different from zero",
          () -> assertThat(id).isNotNull());
      bookinhIds.add(id);
    }
  }

  @Entonces("the reservation will be made correctly")
  public void validateBookingCreation() {
    for (int id : bookinhIds) {
      getBookingInformationAction.getInformation(id);
      jsonSchemaValidationAction.validateJsonSchema(JSON_SCHEMA_BOOKING.getPath());
      List<Map<String, Integer>> ids = getBookingListIdsActions.getBookingIds();
      boolean isTheIdInTheList = ids.stream()
          .anyMatch(booking -> booking.get("bookingid") == id);
      Serenity.reportThat("The id must appear in the list",
          () -> assertThat(isTheIdInTheList).isTrue());
    }
  }
}
