@register
Feature: Register

  @register @positive
    Scenario: user should be able to register new account
    Given user navigate to register page
    When user entry data
    Then user successfully register new account

  @register @negative
  Scenario: user shouldn't be able to register without entry data
    Given user navigate to register page
    When user tap register button
    Then message error should be appear with value "Nama tidak boleh kosong"