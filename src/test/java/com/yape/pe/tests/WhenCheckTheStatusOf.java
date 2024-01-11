package com.yape.pe.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.yape.pe.actions.HealthCheckAction;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Para este escenario de prueba se valida el servicio de estado del API,
 * se valida el codigo de respuesta y el body, se plantea un escenario simple
 * para validar la correcta respuesta del servicio
 */
@RunWith(SerenityRunner.class)
public class WhenCheckTheStatusOf {

  @Steps
  HealthCheckAction healthCheckAction;

  @Test
  public void restfulBookerApplication(){
    String status = healthCheckAction.verifyApplicationStatus();
    Serenity.reportThat("The status must be Created",
        () -> assertThat(status).isEqualTo("Created"));
  }

}
