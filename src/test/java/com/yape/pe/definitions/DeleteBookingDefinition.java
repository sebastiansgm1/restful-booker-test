package com.yape.pe.definitions;

import static com.yape.pe.utils.SessionVariables.SESSION_ID;
import static com.yape.pe.utils.SessionVariables.SESSION_TOKEN;
import static org.assertj.core.api.Assertions.assertThat;

import com.yape.pe.actions.DeleteBookingAction;
import com.yape.pe.actions.GetBookingInformationAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class DeleteBookingDefinition {

  @Steps
  DeleteBookingAction deleteBookingAction;

  @Steps
  GetBookingInformationAction getBookingInformationAction;

  private int id;

  @When("I delete the booking")
  public void deleteBooking() {
    String token = Serenity.sessionVariableCalled(SESSION_TOKEN.getVariable());
    id = Serenity.sessionVariableCalled(SESSION_ID.getVariable());
    deleteBookingAction.deleteById(id, token);
  }

  @Then("The booking will be deleted")
  public void validateDeletedBooking() {
    String response = getBookingInformationAction.consultNonExistentReservation(id);
    Serenity.reportThat("The response must be Not Found",
        () -> assertThat(response).isEqualTo("Not Found"));
  }

}
