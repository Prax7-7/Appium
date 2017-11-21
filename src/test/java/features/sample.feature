Feature: Hello World
  Scenario: Registration Flow Validation via App
    As a user I should be able to see my google account
    when I try to register myself in Quikr

    When I launch Quikr app
    And I choose to log in
    Then I see account picker screen with my email address "prashanthjuly07@gmail.com"



