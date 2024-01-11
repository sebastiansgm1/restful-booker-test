package com.yape.pe.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.yape.pe.actions.GetBookingListIdsActions;
import java.util.List;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class WhenIQueryTheListOfIdentifiers {

  @Steps
  GetBookingListIdsActions getBookingListIdsActions;

  @Test
  public void verifyIdentifiersListService() {
    List idList = getBookingListIdsActions.getBookingIds();
    Serenity.reportThat("The list must contain one or more elements",
        () -> assertThat(idList.size()).isGreaterThan(0));
  }

}
