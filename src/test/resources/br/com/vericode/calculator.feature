Feature: Calculator SpringApplication Test

  Background:
    Given the application is available at "localhost:8080"

  Scenario: Sum of two numbers
    When I send a payload containing two numbers: 5.0 and 15.0, to "/sum"
    Then I should receive a response of 20.0
