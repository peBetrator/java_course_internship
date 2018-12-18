Feature: TestFileReading
  Scenario: Check if file with data exists
    Given User has a file
    When User reads file
    Then Data is displayed