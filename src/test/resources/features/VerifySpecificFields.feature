@SpecificJoke @BackgroundExample
Feature: Verify that Jokes return a positive response and specific fields match expected patterns
  End user knows a joke ID and wants to obtain it, to validate if data structure hasn't changed

  Background:
    Given I know a joke has id of 80
    When I get that specific joke with 80 id

  Scenario: Validate the joke data structure
    Then I validate if following fields match the expected values
      | field     | expected_value                                         |
      | error     | false                                                  |
      | category  | Misc                                                   |
      | type      | twopart                                                |
      | setup     | My wife left me because I'm too insecure and paranoid. |
      | delivery  | Oh wait, never mind. She was just getting the mail.    |
      | id        | 80                                                     |
      | safe      | true                                                   |
      | lang      | en                                                     |
      | nsfw      | false                                                  |
      | religious | false                                                  |
      | political | false                                                  |
      | racist    | false                                                  |
      | sexist    | false                                                  |
      | explicit  | false                                                  |