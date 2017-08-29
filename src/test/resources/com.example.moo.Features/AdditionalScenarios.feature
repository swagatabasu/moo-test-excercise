Feature: I sign in to my Moo account
  And check my order history

 @login
  Scenario Outline:
    Given I am on Moo Home page
    When I login as an existing user
    And verify the login was successful for given '<username>'
   Then I check my order history and logout

      Examples:
        | comment     | username |
        | valid login | Swagata  |