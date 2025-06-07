Feature: Add to Cart and Checkout Flow

Background:
    Given The user is on the SauceDemo login page

  Scenario: User adds two products to the cart and completes the checkout process
    When The user logs in with username "<username>" and password "<password>"
    When the user adds two products to the cart
    And the user proceeds to the checkout page
    And the user fills in checkout information with "Nandini", "VK", and "679303"
    And the user confirms the checkout
    Then the user should see the "Checkout: Complete!" page
    Examples:
  		|username     |password    |
  		|standard_user|secret_sauce|