@login
Feature: Login

  @login @positive
  Scenario: As a user i should be able to login
    Given user navigate to login page
    When user login with username "regie@gmail.com" and password "password"
    Then user should be able to login