Feature: Search
  Scenario: Search for Honda City under used cars

    When I launch Quikr app
    And I choose "Bangalore" as my city
    And I search for "Honda City" under Used Cars
    And I select the first add available
    And I click on the Images available
    Then I swipe to the second Image
