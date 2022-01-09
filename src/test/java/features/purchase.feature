Feature: Purchase

  Scenario Outline: User purchases on Amazon
    Given The user accesses amazon.com page
    When The available page appears
    And User clicks search option and type <product>
    And Results page is displayed
    And User navigates to paging
    And User clicks on <pageNumber> page
    And Results second page is displayed
    And User clicks on the <itemNumber> item
    And Product detail page is displayed
    Then Validate if the product is available and add to cart

    Examples:
      | product | pageNumber  | itemNumber |
      | Alexa   | 2           | 3          |