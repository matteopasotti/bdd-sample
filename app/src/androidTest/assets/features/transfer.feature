Feature: Transfer an amount of money from your Current Account to your Savings

  @transfer
  Scenario Outline: Successful Transfer
    Given I start the application
    And My Current Account is <current_account>
    And My Savings are <savings_account>
    When I click amount_to_transfer field
    And I enter an amount smaller than my current account <amount_to_transfer>
    And I close the keyboard
    And I click Transfer button
    Then I expect to see my Savings increased of that amount
    Examples:
      | current_account    | savings_account  | amount_to_transfer
      | 1000              | 500              | 500