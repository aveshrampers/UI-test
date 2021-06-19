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

  Scenario Outline: Logging in with the incorrect password
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Incorrect error message must be displayed

    Examples:
      | userId                  | password   |
      | arampersadh19@gmail.com | abcd123456 |

  Scenario Outline: Logging in with special characters
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Special characters not allowed error message must be displayed

    Examples:
      | userId  | password   |
      | avesh!# | abcd123456 |

  Scenario Outline: Logging in with a single character
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Username too short error message must be displayed

    Examples:
      | userId | password   |
      | a      | abcd123456 |

  Scenario Outline: Logging in with a incomplete email address
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Email does not look right error message must be displayed

    Examples:
      | userId   | password   |
      | avesh@co | abcd123456 |

  Scenario Outline: Logging in with a username greater than 50 characters
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Username too long error message must be displayed

    Examples:
      | userId                                              | password   |
      | 123456789012345678901234567890a12345678901234567980 | abcd123456 |

  Scenario Outline: Logging in a with short password
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Password too short error message must be displayed

    Examples:
      | userId                  | password |
      | arampersadh19@gmail.com | ab       |

  Scenario Outline: Logging in with a password that is only numeric
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Password isn't valid error message must be displayed

    Examples:
      | userId                  | password  |
      | arampersadh19@gmail.com | 123456789 |

  Scenario Outline: Logging in with a password that is only alphabets
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Invalid password error message must be displayed

    Examples:
      | userId                  | password  |
      | arampersadh19@gmail.com | abcdabcds |

  Scenario Outline: Logging in with a password that is greater than 50 characters
    Given User navigates to "https://www.bbc.co.uk/sport/football/scores-fixtures"
    When User clicks on Sign In link
    And User enters a non registered <userId> and a <password>
    Then Password is too long error message must be displayed

    Examples:
      | userId                  | password                                            |
      | arampersadh19@gmail.com | 123456789012345678901234567890123456789012345678901 |