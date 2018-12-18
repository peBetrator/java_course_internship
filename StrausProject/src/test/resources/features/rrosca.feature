Feature: Scenarios of Radu Marin Rosca

  @R1
  Scenario: User adds products to cart and then removes them
    Given user is on 'Home' page
    And user clicks on 'later' button
    When user clicks on 'restaurants' button
    Then user is on 'SearchRestaurant' page
    When user clicks on 'McDonald's' restaurant
    Then user is on 'Restaurant' page
    And user sets address
    And user adds to cart a 'Cheeseburger'
    Then user accesses cart
    And user removes all from cart

  @R2
#  Scenario Outline: User makes an order without profile
  Scenario: User makes an order without profile
    Given user is on 'Home' page
    And user clicks on 'laterButton' button
    When user clicks on 'restaurants' button
    Then user is on 'SearchRestaurant' page
    When user clicks on 'McDonald's' restaurant
    Then user is on 'Restaurant' page
    And user sets address
    And user adds to cart a 'Big Mac'
    And user goes back to Restaurants page
    Then user is on 'SearchRestaurant' page
    When user clicks on 'Kebab House' restaurant
    Then user is on 'Restaurant' page
    And user adds to cart a 'Small kebab'
    And user accesses cart
    And user makes the order
    And user is on 'Checkout' page
    And user completes the 'name' field with 'Drew' value
    And user completes the 'phone' field with '069000000' value
#    And user fills in the fields with '<name>', '<phone>', '<email>', '<call>', '<terms>'
    And user submits the order
#    Examples:
#      | name      | phone     | email         | call | terms |
#      | Drew      | 069000000 | test@test.com | true | false |


   @R3
   Scenario: User searches for an optimal category
     Given user is on 'Home' page
     And user clicks on 'laterButton' button
     When user clicks on 'restaurants' button
     Then user is on 'SearchRestaurant' page
     When user searches for 'Burger' from 'fast' 'Restaurant'
     And user is on 'Restaurant' page
     And user sets address
     And user selects 'cheap' 'Burgers'
     And user accesses cart
     Then user is on 'Cart' page
