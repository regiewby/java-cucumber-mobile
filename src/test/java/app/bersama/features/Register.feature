@register
Feature: Register

  @register @positive
  Scenario: As a user i should be able to register new account
    Given user navigate to login page
    * user click button daftar to register new account
    * user input valid data with
    When user click button daftar
    Then user should be able to verify to my account page