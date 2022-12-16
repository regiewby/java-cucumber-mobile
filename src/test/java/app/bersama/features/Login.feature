@login
Feature: Login

  @login @positive
  Scenario: As a user i should be able to login
    Given user navigate to login page
    When user login with valid email "asa@gmail.com" and password "123123"
    Then user should be able to login and verify email valid with email "asa@gmail.com"