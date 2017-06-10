Feature: As a Petclinic application user
  I want to see registered pet owners' detail, their pet details and pet appointment details
  And be able to add new pet details and appointments


  @searchAllOwners
  Scenario Outline: Search all owners

    Given I am on Petclinic Home page
    When I search for all pet owners
    Then I verify a list of owners is displayed
    And I click to see '<Owner>' details

    Examples:

      | Comments           | Owner          |
      | View Owner details | Peter McTavish |

  @searchSpecificOwner
  Scenario Outline: Search a specific owner by last name

    Given I am on Petclinic Home page
    When I search for a specific owner by '<lastName>'
    Then I verify if there is any record present for the searched owner

    Examples:

      | Comments                            | lastName  |
      | search by last name - positive      | Black     |
      | search by wrong last name- negative | gibberish |



    @addEditOwner
    Scenario Outline: Add a new pet Owner

      Given I am on Find Owners Page
      And I click on Add Owners button
      When I submit '<FirstName>', '<LastName>', '<Address>', '<City>', '<Telephone>' data
      Then I see the owner information successfully displayed
      Then I edit the city information with '<UpdatedCity>'
      And I see the updated information present in Owner's details

      Examples:
        | Comments                                     | LastName | FirstName | Address      | City    | UpdatedCity | Telephone   |
        | Add a new owner, edit details                | Hemmatty | Matt      | Reading West | Reading | London      | 07345345340 |


      @addOwnerNegativeScenario

      Scenario Outline: Add a new pet Owner; negative scenario

        Given I am on Find Owners Page
        And I click on Add Owners button
        When I submit '<FirstName>', '<LastName>', '<Address>', '<City>', '<Telephone>' data
        Then I see an error message if information are incorrect

        Examples:
          | Comments                                     | LastName | FirstName | Address      | City    | Telephone   |
          | -ve scenario, empty last name                |          | John      | Reading West | Reading | 07345345340 |
          | -ve scenario, non-numeric input in telephone |  Doe     | John      | Reading West | Reading | ddfgfdfg    |

  @addPetAndScheduleVisit @endToEnd

  Scenario Outline: I add new owner and a pet and schedule a visit

    Given I am on Find Owners Page
    And I click on Add Owners button
    When I submit '<FirstName>', '<LastName>', '<Address>', '<City>', '<Telephone>' data
    And I see the owner information successfully displayed
    And I add a new pet with '<petName>','<birthDate>' and '<type>'
    And I schedule a visit for the pet

    Examples:
      | Comments                                        | LastName | FirstName | Address         | City   | Telephone   | petName | birthDate | type |
      | Add a new owner, add a pet and schedule a visit | Campbell | Rueben    | Gillette Corner | London | 07345345340 | snowy   | 2016/04/16  | dog  |
