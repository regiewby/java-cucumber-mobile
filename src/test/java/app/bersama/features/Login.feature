@login
Feature: Login

  @login @positive
  Scenario: As a user i should be able to login
    Given launch mobile driver
    When user entry valid credential
    Then user should be able to login