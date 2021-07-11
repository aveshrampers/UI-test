Feature: As a business user, I would like to make a record of all teams which are playing today

  Scenario: Output all team names with a match today. If there are no matches today, output a message to convey this.
    Given User navigates to "https://www.bbc.com/sport/football/scores-fixtures"
    Then All team names with a match today must be outputted