Feature: Search functionality

  @Search
  Scenario Outline: Search a valid product
    Given user is logged in
    When user search for "<product>"
    Then a page with "<results>" is displayed

    Examples:
      | product         | results |
      | telefon samsung | Samsung |
      | laptop dell     | Dell    |