Feature: straus md scenarios

  @runIt @mnegal
  Scenario: Check if registered user is able to authenticate and then log out
    Given User is on Home page
    When User navigates to LoginPage
    And User fills in "test_user" and "test1!"
    And User is authenticated
    When User logs out
    Then User is not authenticated

  @register @positive @mnegal
  Scenario Outline: verify that user is able to register
    Given User is on Home page
    When User navigates to RegisterPage
    And User fills in "<username>", "<email>"and "<password>"
    Then User is authenticated
    When User logs out
    Then User is not authenticated
    Examples:
      | username | email | password |
      | test_user102 | prank@mail.com | test123 |

  @register @negative @mnegal
  Scenario: verify that user is not able to register while providing invalid data
    Given User is on Home page
    When User navigates to RegisterPage
    And User fills in existing account
    Then User is warned
    When User fills in different passwords
    Then User is warned
