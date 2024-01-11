Feature: As a user I want to validate the booking update service

  Scenario Outline: Validate the correct update of a booking
    Given I authenticate in the booking API
    And I make a reservation with the following information
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Juan      | Vidal    | 201        | true        | 2024-01-10 | 2024-02-14 | Hot water       |
    When I update the booking with the following information
      | firstname   | lastname   | totalprice   | depositpaid   | checkin    | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin>> | <checkout> | <additionalneeds> |
    Then The booking will be updated with the new information

    Examples:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Sebas     | Galeano  | 123        | false       | 2024-02-10 | 2024-03-14 | Food            |
      | Pepe      | Morales  | 524        | true        | 2024-01-11 | 2024-02-15 | Cold water      |

  Scenario Outline: Validate partial booking update
    Given I authenticate in the booking API
    And I make a reservation with the following information
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Juan      | Vidal    | 201        | true        | 2024-01-10 | 2024-02-14 | Hot water       |
    When I make a partial update of the booking
      | firstname   | lastname   | totalprice   | depositpaid   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <additionalneeds> |
    Then The booking will be updated with the new information

    Examples:
      | firstname | lastname | totalprice | depositpaid | additionalneeds |
      | Sebas     | Galeano  | 123        |             |                 |
      | Pepe      |          | 524        |             | Cold water      |
