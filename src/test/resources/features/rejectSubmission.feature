Feature: Verify NCI-2018 Registry search results
  Scenario: Search registry for NCI-2018
    Given I click on trials menu option
    When I click on submitted
    Then I click on search
    Then I click on NCI ID
    Then I click on trial validation
    Then I click on reject
    Then I type trial is out of scope into textarea
    Then I click on done
    Then I assert processing status matches rejected
    Then I click on logout
