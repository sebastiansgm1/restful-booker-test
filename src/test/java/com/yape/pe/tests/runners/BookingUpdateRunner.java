package com.yape.pe.tests.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = "pretty",
    features = "src/test/resources/features/update_booking.feature",
    glue = {"com.yape.pe.definitions"})
public class BookingUpdateRunner {}


