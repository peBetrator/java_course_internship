Feature: Valentin Enache Scenarios

  @V1
  Scenario Outline: Check the Coca-Cola promo
    Given user is on 'Home' page
    And user clicks on 'later' button
    When user clicks on 'cocaCola' menu item
    Then user is on 'CocaColaPromo' page
    When user completes the 'nameField' field with '<name>' value
    And user completes the 'phoneField' field with '<phone>' value
    And user clicks on 'terms_and_conditions' checkbox
    And user clicks on 'play' button
    Then the 'spin' button become available
    And '3' remaining 'attempts' are displayed
    When user clicks on 'spin' button
    Then the raffle result is displayed
    When user clicks on 'close' button
    Then user is on 'Home' page
    Examples:
      | name        | phone        |
      | Test User 1 | +37368765977 |
      | Test User 2 | +37378757321 |

  @V2
  Scenario: Check that a canceled order appear in a user profile history
    Given user is on 'Home' page
    When user clicks on 'later' button
    And user navigates to LoginPage
    And user is on 'Login' page
    And user completes the 'usernameInput' field with 'caheletavi12' value
    And user completes the 'passwordInput' field with 'qwerty123' value
    And  user clicks on 'submit' button
    Then user is authenticated
    And user is on 'Home' page
    When user clicks on 'restaurants' button
    Then  user is on 'SearchRestaurant' page
    When user clicks on 'McDonald's' restaurant
    And user sets address
    And user adds to cart a 'Cheeseburger'
    Then user accesses cart
    Then user is on 'Cart' page
    And the cart contain 1 'Big Mac'
    When user clicks on 'confirmOrder' button
    And user completes the 'Checkout' form with following data
      | name         | phone        | email                  | apartment | entrance | floor | code | acceptTerm |
      | TestCustomer | +37368123123 | testCustomer@gmail.com | 22        | 3        | 4     | 1234 | true       |
    Then user is on 'OrderDetails' page
    When user clicks on 'cancelOrder' button
    And user completes the 'reason' field with 'I have changed my mind' value
    And user clicks on 'confirmCancel' button
#    And user check the profile page
#    Then the canceled order is apear in the user profile history

#  Scenario Template: Check the delivery cost based on the cost of the order
#    Given user is on 'Home' page
#    When user clicks on '<string>' button '' Restaurant
#    And user adds to cart '<quant1>' '<item>'
#    And user accesses Cart page
#    Then user is on 'Cart' page
#    And the delivery cost is '<delivCost1>' lei
#    And the order cost is '<ordCost1>' lei
#    When user increase quantity to '<quant2>'
#    Then the delivery cost is '<delivCost2>' lei
#    And the order cost is '<ordCost2>' lei
#    When user increase quantity to '<quant3>'
#    Then the delivery cost is '<delivCost3>' lei
#    And the order cost is '<ordCost3>' lei
#
#    Examples:
#      | restaurant | item                       | quant1 | ordCost1 | delivCost1 | quant2 | ordCost2 | delivCost2 | quant3 | ordCost3 | delivCost3 |
#      | Kozlovna   | Royal burger               | 1      | 105      | 50         | 4      | 420      | 35         | 5      | 525      | 0          |
#      | Caruso     | Pizza Moldova mica clasica | 1      | 100      | 50         | 9      | 900      | 35         | 10     | 1000     | 0          |
