@RandomJokes @Scenarios
Feature: Get a random joke and validate the response structure
  End user wants to obtain a random joke,
  and know what happens when they accidentally send a bad request

  Scenario: Get a random, valid joke and validate its' structure
    Given I want a single random joke
    When I obtain a single random joke
    Then I should see a positive response
    Then I should see "Error" section
    Then I should see "Category" section
    Then I should see "Type" section
    Then I should see a list of flags
    Then I should see "Safe" section
    Then I should see "Id" section
    Then I should see "Language" section

  Scenario: Get up to 10 random jokes and validate their count
    Given I want 10 jokes
    When I obtain 10 jokes
    Then I should see a positive response
    Then I should see 10 jokes

  Scenario: Get a random, invalid joke, validate negative response and returned error
    Given I want a joke that does not exist
    When I try to obtain a non-existent joke
    Then I should see a negative response