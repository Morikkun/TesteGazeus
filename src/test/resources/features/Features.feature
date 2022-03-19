Feature: Interacting with elements on the Jogatina.com webpage

  Scenario: Click on the sign up button
    Given I am at the Jogatina page
    When I click on the Sign up button
    Then the form for email should appear
    And the form for password should appear

  Scenario: Creating a new account
    Given I am at the Jogatina page
    When I click on the Sign up button
    And I type in my email
    And I type in my password
    And I click on the create account button
    Then my account should be created

  Scenario: Check for text
    Given I want to check for a text on the Jogatina page
    When I open the Jogatina page
    Then the text should be there

