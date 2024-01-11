package com.yape.pe.definitions;

import static com.yape.pe.models.booking.Booking.getBooking;
import static com.yape.pe.utils.SessionVariables.SESSION_ID;
import static com.yape.pe.utils.SessionVariables.SESSION_TOKEN;
import static com.yape.pe.utils.Users.ADMIN_USER;
import static com.yape.pe.utils.Utils.removeNulls;

import com.yape.pe.actions.AuthRestfulBookerApplicationAction;
import com.yape.pe.actions.GetBookingInformationAction;
import com.yape.pe.actions.UpdateBookingAction;
import com.yape.pe.models.booking.Booking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class BookingUpdateDefinition {

  @Steps
  AuthRestfulBookerApplicationAction authRestfulBookerApplicationAction;
  @Steps
  UpdateBookingAction updateBookingAction;
  @Steps
  GetBookingInformationAction getBookingInformationAction;

  private int id;
  Booking updatedBookingInformation;
  Booking newBookingInformation;

  private String token;

  @Given("I authenticate in the booking API")
  public void login(){
    token = authRestfulBookerApplicationAction.authApiRequest(ADMIN_USER.getUserName(),
        ADMIN_USER.getPassword());
    Serenity.setSessionVariable(SESSION_TOKEN.getVariable()).to(token);
  }

  @When("I update the booking with the following information")
  public void updateBookingInformation(List<Map<String,String>> bookingData){
    id = Serenity.sessionVariableCalled(SESSION_ID.getVariable());
    newBookingInformation = getBooking(bookingData.get(0));
    updatedBookingInformation = updateBookingAction.updateBooking(newBookingInformation, token, id);
  }

  /**
   * Para la actualización parcial, envio un mapa con los campos que deseo actualizar
   * Luego para la comparación consulto el servicio get para traer la información completa de la
   * reservación y así validar que se hayan actualizado los campos
   */
  @When("I make a partial update of the booking")
  public void partiallyUpdateBooking(List<Map<String,Object>> bookingData){
    id = Serenity.sessionVariableCalled(SESSION_ID.getVariable());
    Map<String, Object> filteredMap = removeNulls(bookingData.get(0));
    updatedBookingInformation = updateBookingAction.partiallyUpdate(filteredMap, token, id);
    newBookingInformation = getBookingInformationAction.getInformation(id);
  }

  @Then("The booking will be updated with the new information")
  public void validateUpdateInformation(){
    updateBookingAction.compareBookingInformation(newBookingInformation, updatedBookingInformation);
  }

}
