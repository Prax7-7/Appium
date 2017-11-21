Feature: Web Quickr App login
  Scenario: Registration Flow Validation via App
  As a user I want to verify that
  I get the option to register using facebook

    When I launch Quickr mobile web
    And I choose to register
    Then I should see an option to register using Facebook

