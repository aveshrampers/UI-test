Feature: As a business user, I would like to make a record of all teams which are playing today

  Scenario: Output all team names with a match today. If there are no matches today, output a message to convey this.
    Given User open url "https://www.bbc.co.uk/"
    When User clicks on Sport menu
    Then User clicks on Football menu
    Then User clicks on Scores&Fixtures link
    And All team names with a match today must be outputted