@SpecificJoke @ScenarioOutlines
Feature: Obtain specific joke using its' ID
  End user wants to obtain a specific joke, knowing only the Joke ID

  Scenario Outline: Get a joke knowing its' ID
    Given I know a joke has id of <joke_id>
    When I get that specific joke
    Then I should see a positive response
    Then I should get a joke with <joke_id> id

    Examples:
    | joke_id |
    | 200     |
    | 150     |
    | 5       |