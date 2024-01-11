Feature: As a user I want to validate the booking delete service

  Scenario: Validate the correct delete of a booking
    Given I authenticate in the booking API
    And I make a reservation with the following information
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Juan      | Vidal    | 201        | true        | 2024-01-10 | 2024-02-14 | Hot water       |
    When I delete the booking
    Then The booking will be deleted