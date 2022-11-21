Feature: Calculator Tests

  Background:
    Given the application is available at "http://localhost:8080"

  Scenario: Sum
    When I send a payload containing two numbers: 5.0 and 15.0, to "/sum"
    Then I should receive a response of 20.0

  Scenario: Division
    When I send a payload containing two numbers: 50.0 and 10.0, to "/divide"
    Then I should receive a response of 5.0
