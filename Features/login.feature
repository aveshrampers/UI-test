Feature:As a QA, I would like to verify all negative scenarios for login

  Scenario Outline: Logging in with a non registered email.
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Cant find email message must be displayed

    Examples:
      | userId          | password  |
      | test19@mail.com | 123456asd |

  Scenario Outline: Logging in with a non registered username.
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Cant find username message must be displayed

    Examples:
      | userId | password  |
      | test19 | 123456asd |

  Scenario Outline: Logging in with a blank credentials
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Error messages must be displayed

    Examples:
      | userId | password |
      |        |          |