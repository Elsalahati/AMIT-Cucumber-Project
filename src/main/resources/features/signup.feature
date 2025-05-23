Feature: Test New User Sign-Up

  Scenario: Sign-Up with new user
    Given user opens up homepage and click on signup button
    When user enters new username & password and click on signup
    Then successful message appears to user

  Scenario: Sign-Up with existing user
    Given user opens up homepage and click on signup button
    When user enters existing username & password and click on signup
    Then error message appears to user as an existing user