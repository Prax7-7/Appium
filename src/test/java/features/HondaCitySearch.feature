@search
Feature: Search
  Scenario: Search for Honda City under used cars

    When I launch Quikr app
    And I choose "Bangalore" as my city
    And I search for "Honda City" under Used Cars
    Then I should see the first car search result with "Honda"
