@register
Feature: Register

  @register @positive
  Scenario: user should be able to register new account
    Given user navigate to register page
    When user entry data
    Then user successfully register new account
