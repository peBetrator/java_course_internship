# to run your own scenarios
# tag them with "@yourTag"
# and change tag to your in RunCukes.java
Feature: straus

  @login @positive @mnegal
  Scenario: Check if registered user is able to authenticate and then log out
    Given user is on 'Home' page
    And user clicks on 'later' button
    And user clicks on 'loginDropdown' button
    And user clicks on 'login' button
#    When user navigates to LoginPage
    Then user is on 'Login' page
    When user completes the 'usernameInput' field with 'test_user' value
    And user completes the 'passwordInput' field with 'test1!' value
    And user clicks on 'submit' button
    And user is on 'Home' page
    And user is authenticated
    And user clicks on 'signOut' button
    Then user is not authenticated

  @register @positive @mnegal
  Scenario Outline: verify that user is able to register
    Given user is on 'Home' page
    And user clicks on 'later' button
#    When user navigates to RegisterPage
    And user clicks on 'loginDropdown' button
    And user clicks on 'login' button
    Then user is on 'Login' page
    When user clicks on 'registerButton' button
    Then user is on 'Register' page
    When user completes the 'usernameInput' field with '<username>' value
    And user completes the 'mailInput' field with '<email>' value
    And user completes the 'password1Input' field with '<password>' value
    And user completes the 'password2Input' field with '<password>' value
    And user clicks on 'submit' button
    Then user user is registered
    Examples:
      | username     | email          | password |
      | test_user203 | prank@mail.com | test123  |
      | test_user204 | yrureading@this.com | pass321  |

  @register @negative @mnegal
  Scenario: verify that user is not able to register while providing invalid data
    Given user is on 'Home' page
    And user clicks on 'later' button
    And user navigates to RegisterPage
    When user is on 'Register' page
    And user fills in duplicate account
    Then user is warned about duplicate
    When user fills in different passwords
    Then user is warned about password mismatch

  @chat @negative @mnegal
  Scenario: verify that user is not able to start chat while providing invalid data
    Given user is on 'Home' page
    And user clicks on 'later' button
    When user accesses Help iframe
    And user fills in only Name
    And user fills in only Phone

  @chat @positive @mnegal
  Scenario: verify that user is able to start chat
    Given user is on 'Home' page
    And user clicks on 'later' button
    When user accesses Help iframe
    And user fills in only Credentials
    And user opens chat menu
    And user navigates to EmailTranscript from chat
    And user submits email address
    And user sends 'Livrati la apartament?' in chat
    And user opens chat menu
    And user navigates to EndThisChatSession from chat

  @asserts @address @negative @mnegal
  Scenario: verify that user is warned that delivery address is out of zone
    Given user is on 'Home' page
    When user clicks on 'setAddress' button
    And user completes the 'addressInput' field with 'sstr. Schinoasa' value
    And user clarifies address
    And user completes the 'streetInput' field with '13' value
    And user clicks on 'confirm' button
    And user clicks on 'restaurants' button
    And user is on 'SearchRestaurant' page
    And user clicks on 'McDonald's' restaurant
    And user is on 'Restaurant' page
    Then user is warned about higher price
    When user adds to cart a 'Cheeseburger'
    And user accesses cart
    And user makes the order
    And user is on 'Checkout' page
    Then user is warned that delivery is not possible