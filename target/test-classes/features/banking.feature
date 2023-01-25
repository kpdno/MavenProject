Feature: Banking application money movents 
 
  
  Scenario: Money deposit 
    Given User account exists with 10000 dollars in it
    And  User has access to his account
    When User logs in to the bank app
    And User opens money deposit page
    And User deposits check for 2000 dollars
    Then Page displays the confirmation of the deposit
    And Balance should get incremented to 2000 dollars

 