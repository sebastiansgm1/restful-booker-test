Feature: As a user I want to validate the creation of a booking

  Scenario: Successful creation and verify booking
    Given I check the status of the booking service
    When I make a reservation with the following information
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Juan      | Vidal    | 201        | true        | 2024-01-10 | 2024-02-14 | Hot water       |
      | Pepito    | Perez    | 205        | false       | 2024-01-10 | 2024-02-14 | Cold water      |
    Then the reservation will be made correctly