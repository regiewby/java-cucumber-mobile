@register
Feature: Register

  @register @positive
  Scenario: As a user i should be able to register new account
    Given user navigate to login page
    * user click button daftar to register new account
    * user input valid data with "oka mahardika", "oka@gmail.com", "123456abc", "08172839181", "denpasar", "jalan jalan dibali"
    When user click button daftar
    Then user should be able to login and verify email valid with email "oka@gmail.com"