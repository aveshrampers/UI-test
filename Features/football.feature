Feature: As a business user, I would like to navigate to the football page

  Scenario: User navigates to football page
    Given User navigates to "https://www.bbc.com"
    Then All team names with a match today must be outputted