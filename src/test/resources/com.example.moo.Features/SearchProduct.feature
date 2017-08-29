Feature: As a customer I want to search for product
  and get appropriate results


  @validSearch
  Scenario Outline: Search a product

    Given I am on Moo Home page
    When I search for a '<product>'
    Then I verify the search result page is displayed for correct '<product>'
    And I verify if the search returned valid results

    Examples:

      | Scenario     | product       |
      | valid search | postcard      |
      | valid search | business card |

  @invalidSearch
  Scenario Outline: Search a product

    Given I am on Moo Home page
    When I search for an invalid '<product>'
    Then I verify the search result page is displayed for correct '<product>'
    And I verify if the search returned an error message

    Examples:

      | Scenario     | product  |
      | valid search | blabla   |

