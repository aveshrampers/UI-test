Feature: As a sports user, I would like to read about all articles related to sports

  Scenario: Use the search option to find all articles related to ‘sports’. Output the first heading and the last heading returned on the page.
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on search bar and searches for sports
    Then First and Last heading must be outputted