Feature: Ebebek Biberon Case

  Scenario: The home page opens. (www.e-bebek.com)
    Given Type bottle in the search bar.
    When The search is done.
    And Click the Add to Cart button.
    And Click the View Cart button.
    Then Check that the product has been added to the cart



