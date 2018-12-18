Feature: TestParsingData
  Scenario: Check if data is parsed to User class
    Given User has a "User" class
    When User reads file
    And User splits data
    And User parses data to class
    Then Class data is displayed