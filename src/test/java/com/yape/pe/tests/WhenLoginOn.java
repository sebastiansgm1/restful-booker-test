package com.yape.pe.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.yape.pe.actions.AuthRestfulBookerApplicationAction;
import java.util.Arrays;
import java.util.Collection;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Esta es una prueba automatizada de los servicios de autenticación
 * Para efectos de la prueba se usa un escenario parametrizable con dos ejecuciones usando
 * un usuario correcto y un usuario incorrecto para validar que las aserciones esten
 * parametrizadas correctamente
 * Para hacer el escenario más simple se usa BDD pero no se crea una prueba con cucumber ya que la
 * prueba contiene una sola llamada
 */
@RunWith(SerenityParameterizedRunner.class)
public class WhenLoginOn {

  @Steps
  AuthRestfulBookerApplicationAction authRestfulBookerApplicationAction;
  private final String userName;
  private final String password;

  public WhenLoginOn(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  @TestData(columnNames = "Username, Password")
  public static Collection<Object[]> testData(){
    return Arrays.asList(
        new Object[][] {
            {"admin", "password123"},
            {"admin", "password124"},
        }
    );
  }

  @Test
  public void restfulBookerApplication(){
    String token = authRestfulBookerApplicationAction.authApiRequest(userName, password);
    Serenity.reportThat("The token must be different from null",
        () -> assertThat(token).isNotNull());
  }

}
