Feature: End-To-End add items to cart and purchase them

  Scenario: LogIn Existing User
    Given user opens up homepage and click on login button
    When user enters existing username & password and click on login
    Then welcome message appears to user on homepage with his name

  Scenario: User selects 2 products & Validate the Total amount
    Given user goes to homepage selects first product, adds it to cart and click on homepage
    And user goes to homepage selects second product, adds it to cart and click on cart
    And validate products' names & prices
    And compare the total amount with the sum of selected products
    When user clicks on place order button
    And  user fills in his data and click on purchase
    Then user receives a confirmation message then clicks ok button ending process