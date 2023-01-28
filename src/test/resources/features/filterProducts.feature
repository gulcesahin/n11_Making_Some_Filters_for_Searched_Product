Feature: Adding products and going to payment

  @addingProductsToTheBasket
  Scenario: Add desired products to the basket and go to payment page
    Given User opens the browser and goes to the home page and searches for the product "telefon" on the search bar
    When User selects some filters
    Then User sees that filters are okay